package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerComposeConfigurationOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerEnvironmentVariable
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.execution.RunManager
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.nio.file.Paths

class DockerComposeConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var dockerRunConfigurationCreator: DockerRunConfigurationCreator
    private lateinit var settingsApplier: SettingsApplier<DockerComposeConfigurationSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        dockerRunConfigurationCreator = DockerRunConfigurationCreator(project)
        runManager = RunManager.getInstance(project)
        settingsApplier = DockerComposeConfigurationSettingsApplier(dockerRunConfigurationCreator, runManager)
    }

    @Test
    fun servicesApplied() {
        settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
                .name("Docker Compose Services")
                .services(listOf("service1"))
                .build())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Services").services)
                .containsExactly("service1")
    }

    @Test
    fun composeFilesApplied() {
        settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
                .name("Docker Compose Files")
                .composeFiles(listOf(
                        Paths.get(project.basePath).resolve("docker-compose.yml"),
                        Paths.get(project.basePath).resolve("docker-compose-2.yml"),
                        Paths.get(project.basePath).resolve("docker-compose-3.yml")))
                .build())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Files").sourceFilePath)
                .isEqualTo(Paths.get(project.basePath).resolve("docker-compose.yml").toString())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Files").secondarySourceFiles)
                .containsExactly(
                        Paths.get(project.basePath).resolve("docker-compose-2.yml").toString(),
                        Paths.get(project.basePath).resolve("docker-compose-3.yml").toString())
    }

    @Test
    fun environmentVariablesApplied() {
        settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
                .name("Docker Compose Environment Variables")
                .environmentVariables(listOf(
                        ImmutableDockerEnvironmentVariable.builder()
                                .name("name")
                                .value("value")
                                .build()))
                .build())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Environment Variables").envVars)
                .containsExactly(DockerEnvVarImpl("name", "value"))
    }

    @Test
    fun forceBuildApplied() {
        settingsApplier.apply(ImmutableDockerComposeConfigurationSettings.builder()
                .name("Docker Compose Force Build")
                .options(ImmutableDockerComposeConfigurationOptionsSettings.builder()
                        .buildForceBuildImages(true)
                        .build())
                .build())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Force Build").runCliOptions)
                .isEqualTo("--build")
    }

    private fun getDockerDeploymentConfiguration(name: String): DockerDeploymentConfiguration {
        val runnerAndConfigurationSettings = runManager.findConfigurationByName(name)
        assertThat(runnerAndConfigurationSettings).isNotNull()
        val deployToServerRunConfiguration = runnerAndConfigurationSettings!!.configuration as DeployToServerRunConfiguration<*, *>
        return deployToServerRunConfiguration.deploymentConfiguration as DockerDeploymentConfiguration
    }
}
