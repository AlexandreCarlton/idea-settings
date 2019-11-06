package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker;

import static java.util.stream.Collectors.toList;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerEnvironmentVariable;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerExecutableSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBinding;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBindingProtocol;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface;
import com.intellij.docker.DockerDeploymentConfiguration;
import com.intellij.docker.DockerRunConfigurationCreator;
import com.intellij.docker.agent.settings.DockerEnvVarImpl;
import com.intellij.docker.agent.settings.DockerPortBindingImpl;
import com.intellij.docker.deploymentSource.DockerImageDeploymentSourceType;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import javax.inject.Inject;

public class DockerImageConfigurationSettingsApplier implements SettingsApplier<DockerImageConfigurationSettings> {

  private final DockerRunConfigurationCreator dockerRunConfigurationCreator;
  private final RunManager runManager;

  @Inject
  public DockerImageConfigurationSettingsApplier(DockerRunConfigurationCreator dockerRunConfigurationCreator, RunManager runManager) {
    this.dockerRunConfigurationCreator = dockerRunConfigurationCreator;
    this.runManager = runManager;
  }

  @Override
  public void apply(DockerImageConfigurationSettings settings) {

    final DockerDeploymentConfiguration dockerDeploymentConfiguration = new DockerDeploymentConfiguration();
    settings.imageId().ifPresent(dockerDeploymentConfiguration::setImageTag);
    settings.containerName().ifPresent(dockerDeploymentConfiguration::setContainerName);
    settings.publishExposedPortsToTheHostInterfaces()
        .map(this::toPublishAllPorts)
        .ifPresent(dockerDeploymentConfiguration::setPublishAllPorts);
    settings.executable().flatMap(DockerExecutableSettings::entrypoint)
        .ifPresent(dockerDeploymentConfiguration::setEntrypoint);
    settings.executable().flatMap(DockerExecutableSettings::command)
        .ifPresent(dockerDeploymentConfiguration::setCommand);
    settings.bindPorts().ifPresent(bindings -> dockerDeploymentConfiguration.setPortBindings(
        bindings.stream()
            .map(this::toDockerPortBindingImpl)
            .collect(toList())));
    settings.environmentVariables().ifPresent(variables -> dockerDeploymentConfiguration.setEnvVars(
        variables.stream()
          .map(this::toDockerEnvVarImpl)
          .collect(toList())));
    settings.runOptions().ifPresent(dockerDeploymentConfiguration::setRunCliOptions);

    final RunnerAndConfigurationSettings runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
        DockerImageDeploymentSourceType.getInstance().getSingletonSource(),
        dockerDeploymentConfiguration,
        null);
    runnerAndConfigurationSettings.setName(settings.name());
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }

  private boolean toPublishAllPorts(DockerPublishToHostInterface publishToHostInterface) {
    switch (publishToHostInterface) {
      case ALL: return true;
      case SPECIFY: return false;
      default:
        throw new IllegalArgumentException("Unhandled DockerPublishToHostInterface: " + publishToHostInterface);
    }
  }

  private DockerPortBindingImpl toDockerPortBindingImpl(DockerPortBinding dockerPortBinding) {
    final DockerPortBindingImpl dockerPortBindingImpl = new DockerPortBindingImpl();
    dockerPortBinding.hostPort().ifPresent(dockerPortBindingImpl::setHostPort);
    dockerPortBinding.containerPort().ifPresent(dockerPortBindingImpl::setContainerPort);
    dockerPortBinding.hostIp().ifPresent(dockerPortBindingImpl::setHostIp);
    dockerPortBinding.protocol().map(this::toProtocolString).ifPresent(dockerPortBindingImpl::setProtocol);
    return dockerPortBindingImpl;
  }

  private DockerEnvVarImpl toDockerEnvVarImpl(DockerEnvironmentVariable dockerEnvironmentVariable) {
    DockerEnvVarImpl dockerEnvVarImpl = new DockerEnvVarImpl();
    dockerEnvironmentVariable.name().ifPresent(dockerEnvVarImpl::setName);
    dockerEnvironmentVariable.value().ifPresent(dockerEnvVarImpl::setValue);
    return dockerEnvVarImpl;
  }

  private String toProtocolString(DockerPortBindingProtocol protocol) {
    switch (protocol) {
      case TCP: return "tcp";
      case UDP: return "udp";
      default:
        throw new IllegalArgumentException("Unhandled DockerPortBindingProtocol: " + protocol);
    }
  }
}
