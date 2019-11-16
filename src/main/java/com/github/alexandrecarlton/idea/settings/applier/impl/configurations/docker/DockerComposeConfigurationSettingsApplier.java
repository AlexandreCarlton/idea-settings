package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker;

import static java.util.stream.Collectors.toList;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationOptionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerEnvironmentVariable;
import com.intellij.docker.DockerDeploymentConfiguration;
import com.intellij.docker.DockerRunConfigurationCreator;
import com.intellij.docker.agent.settings.DockerEnvVarImpl;
import com.intellij.docker.deploymentSource.DockerComposeDeploymentSourceType;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import java.nio.file.Path;
import java.util.Optional;
import javax.inject.Inject;

public class DockerComposeConfigurationSettingsApplier implements SettingsApplier<DockerComposeConfigurationSettings> {

  private final DockerRunConfigurationCreator dockerRunConfigurationCreator;
  private final RunManager runManager;

  @Inject
  public DockerComposeConfigurationSettingsApplier(DockerRunConfigurationCreator dockerRunConfigurationCreator,
                                                   RunManager runManager) {
    this.dockerRunConfigurationCreator = dockerRunConfigurationCreator;
    this.runManager = runManager;
  }

  @Override
  public void apply(DockerComposeConfigurationSettings settings) {
    final DockerComposeDeploymentSourceType dockerComposeDeploymentSourceType = DockerComposeDeploymentSourceType.getInstance();
    final DockerDeploymentConfiguration dockerDeploymentConfiguration = new DockerDeploymentConfiguration();

    settings.services()
        .ifPresent(dockerDeploymentConfiguration::setServices);

    settings.composeFiles()
        .map(composeFiles -> composeFiles.stream()
            .map(Path::toAbsolutePath)
            .map(Path::toString)
            .collect(toList()))
        .flatMap(composeFiles -> composeFiles.isEmpty()
            ? Optional.empty()
            : Optional.of(composeFiles))
        .ifPresent(composeFiles -> {
            dockerDeploymentConfiguration.setSourceFilePath(composeFiles.get(0));
            dockerDeploymentConfiguration.setSecondarySourceFiles(composeFiles.subList(1, composeFiles.size()));
        });

    settings.environmentVariables().ifPresent(variables -> dockerDeploymentConfiguration.setEnvVars(
        variables.stream()
            .map(this::toDockerEnvVarImpl)
            .collect(toList())));

    settings.options()
        .flatMap(DockerComposeConfigurationOptionsSettings::buildForceBuildImages)
        .ifPresent(build -> dockerComposeDeploymentSourceType.applyForceBuild(dockerDeploymentConfiguration, build));

    final RunnerAndConfigurationSettings runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
        dockerComposeDeploymentSourceType.getSingletonSource(),
        dockerDeploymentConfiguration,
        null);
    runnerAndConfigurationSettings.setName(settings.name());
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }

  private DockerEnvVarImpl toDockerEnvVarImpl(DockerEnvironmentVariable dockerEnvironmentVariable) {
    DockerEnvVarImpl dockerEnvVarImpl = new DockerEnvVarImpl();
    dockerEnvironmentVariable.name().ifPresent(dockerEnvVarImpl::setName);
    dockerEnvironmentVariable.value().ifPresent(dockerEnvVarImpl::setValue);
    return dockerEnvVarImpl;
  }
}
