package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBindingProtocol;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerEnvironmentVariable;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerExecutableSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerImageConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerPortBinding;
import com.google.common.collect.ImmutableList;
import com.intellij.docker.DockerDeploymentConfiguration;
import com.intellij.docker.DockerRunConfigurationCreator;
import com.intellij.docker.agent.settings.DockerEnvVarImpl;
import com.intellij.docker.agent.settings.DockerPortBindingImpl;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration;
import org.junit.Before;
import org.junit.Test;

public class DockerImageConfigurationSettingsApplierTest extends IdeaSettingsTestFixture  {

  private DockerRunConfigurationCreator dockerRunConfigurationCreator;
  private SettingsApplier<DockerImageConfigurationSettings> settingsApplier;
  private RunManager runManager;


  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    dockerRunConfigurationCreator = new DockerRunConfigurationCreator(project);
    runManager = RunManager.getInstance(project);
    settingsApplier = new DockerImageConfigurationSettingsApplier(dockerRunConfigurationCreator, runManager);
  }

  @Test
  public void imageIdApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Image ID")
        .imageId("hello-world")
        .build());
    assertThat(getDockerDeploymentConfiguration("Image ID").getImageTag()).isEqualTo("hello-world");
  }

  @Test
  public void containerNameApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Container Name")
        .containerName("container-name")
        .build());
    assertThat(getDockerDeploymentConfiguration("Container Name").getContainerName()).isEqualTo("container-name");
  }

  @Test
  public void publishtToHostInterfaceApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Publish all")
        .publishExposedPortsToTheHostInterfaces(DockerPublishToHostInterface.ALL)
        .build());
    assertThat(getDockerDeploymentConfiguration("Publish all").isPublishAllPorts()).isTrue();
  }

  @Test
  public void executableApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Executable")
        .executable(ImmutableDockerExecutableSettings.builder()
            .command("command")
            .entrypoint("/bin/entrypoint")
            .build())
        .build());
    assertThat(getDockerDeploymentConfiguration("Executable").getEntrypoint()).isEqualTo("/bin/entrypoint");
    assertThat(getDockerDeploymentConfiguration("Executable").getCommand()).isEqualTo("command");
  }

  @Test
  public void portBindingApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Port Binding")
        .bindPorts(ImmutableList.of(
            ImmutableDockerPortBinding.builder()
                .containerPort(1234)
                .hostPort(5678)
                .hostIp("1.2.3.4")
                .protocol(DockerPortBindingProtocol.TCP)
                .build()))
        .build());
    DockerPortBindingImpl expectedDockerPortBindingImpl = new DockerPortBindingImpl();
    expectedDockerPortBindingImpl.setContainerPort(1234);
    expectedDockerPortBindingImpl.setHostPort(5678);
    expectedDockerPortBindingImpl.setHostIp("1.2.3.4");
    expectedDockerPortBindingImpl.setProtocol("tcp");
    assertThat(getDockerDeploymentConfiguration("Port Binding").getPortBindings())
        .containsExactly(expectedDockerPortBindingImpl);
  }

  @Test
  public void environmentVariablesApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Environment Variables")
        .environmentVariables(ImmutableList.of(
            ImmutableDockerEnvironmentVariable.builder()
                .name("name")
                .value("value")
                .build()))
        .build());
    assertThat(getDockerDeploymentConfiguration("Environment Variables").getEnvVars())
        .containsExactly(new DockerEnvVarImpl("name", "value"));
  }

  @Test
  public void runOptionsApplied() {
    settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
        .name("Run Options")
        .runOptions("--rm -it")
        .build());
    assertThat(getDockerDeploymentConfiguration("Run Options").getRunCliOptions())
        .isEqualTo("--rm -it");
  }

  private DockerDeploymentConfiguration getDockerDeploymentConfiguration(String name) {
    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName(name);
    assertThat(runnerAndConfigurationSettings).isNotNull();
    DeployToServerRunConfiguration deployToServerRunConfiguration = (DeployToServerRunConfiguration) runnerAndConfigurationSettings.getConfiguration();
    return (DockerDeploymentConfiguration) deployToServerRunConfiguration.getDeploymentConfiguration();
  }

}
