package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerComposeConfigurationOptionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerComposeConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerEnvironmentVariable;
import com.google.common.collect.ImmutableList;
import com.intellij.docker.DockerDeploymentConfiguration;
import com.intellij.docker.DockerRunConfigurationCreator;
import com.intellij.docker.agent.settings.DockerEnvVarImpl;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration;
import java.nio.file.Paths;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class DockerComposeConfigurationSettingsApplierTest extends IdeaSettingsTestFixture {

  private DockerRunConfigurationCreator dockerRunConfigurationCreator;
  private SettingsApplier<DockerComposeConfigurationSettings> settingsApplier;
  private RunManager runManager;


  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    dockerRunConfigurationCreator = new DockerRunConfigurationCreator(project);
    runManager = RunManager.getInstance(project);
    settingsApplier = new DockerComposeConfigurationSettingsApplier(dockerRunConfigurationCreator, runManager);
  }

  @Test
  public void servicesApplied() {
    settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
        .name("Docker Compose Services")
        .services(Collections.singletonList("service1"))
        .build());
    assertThat(getDockerDeploymentConfiguration("Docker Compose Services").getServices())
        .containsExactly("service1");
  }

  @Test
  public void composeFilesApplied() {
    settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
        .name("Docker Compose Files")
        .composeFiles(ImmutableList.of(
            Paths.get(project.getBasePath()).resolve("docker-compose.yml"),
            Paths.get(project.getBasePath()).resolve("docker-compose-2.yml"),
            Paths.get(project.getBasePath()).resolve("docker-compose-3.yml")))
        .build());
    assertThat(getDockerDeploymentConfiguration("Docker Compose Files").getSourceFilePath())
        .isEqualTo(Paths.get(project.getBasePath()).resolve("docker-compose.yml").toString());
    assertThat(getDockerDeploymentConfiguration("Docker Compose Files").getSecondarySourceFiles())
        .containsExactly(
            Paths.get(project.getBasePath()).resolve("docker-compose-2.yml").toString(),
            Paths.get(project.getBasePath()).resolve("docker-compose-3.yml").toString());
  }

  @Test
  public void environmentVariablesApplied() {
    settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
        .name("Docker Compose Environment Variables")
        .environmentVariables(ImmutableList.of(
            ImmutableDockerEnvironmentVariable.builder()
                .name("name")
                .value("value")
                .build()))
        .build());
    assertThat(getDockerDeploymentConfiguration("Docker Compose Environment Variables").getEnvVars())
        .containsExactly(new DockerEnvVarImpl("name", "value"));
  }

  @Test
  public void forceBuildApplied() {
    settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
        .name("Docker Compose Force Build")
        .options(ImmutableDockerComposeConfigurationOptionsSettings.builder()
            .buildForceBuildImages(true)
            .build())
        .build());
    assertThat(getDockerDeploymentConfiguration("Docker Compose Force Build").getRunCliOptions())
        .isEqualTo("--build");
  }

  private DockerDeploymentConfiguration getDockerDeploymentConfiguration(String name) {
    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName(name);
    assertThat(runnerAndConfigurationSettings).isNotNull();
    DeployToServerRunConfiguration deployToServerRunConfiguration = (DeployToServerRunConfiguration) runnerAndConfigurationSettings.getConfiguration();
    return (DockerDeploymentConfiguration) deployToServerRunConfiguration.getDeploymentConfiguration();
  }
}
