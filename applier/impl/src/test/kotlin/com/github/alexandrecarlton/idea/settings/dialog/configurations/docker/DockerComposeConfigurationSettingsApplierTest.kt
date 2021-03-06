package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.DockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment.EnvironmentVariable
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File
import java.nio.file.Paths

class DockerComposeConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<DockerComposeConfigurationSettings>

    @Before
    public override fun setUp() {
        settingsApplier = DockerComposeConfigurationSettingsApplier(platform.dockerRunConfigurationCreator, platform.runManager)
    }

    @Test
    fun serverApplied() {
        settingsApplier.apply(DockerComposeConfigurationSettings(
            name = "Docker Compose Server",
            server = "Docker"))
        val runnerAndConfigurationSettings = platform.runManager.findConfigurationByName("Docker Compose Server")
        val deployToServerRunConfiguration = runnerAndConfigurationSettings!!.configuration as DeployToServerRunConfiguration<*, *>
        assertThat(deployToServerRunConfiguration.serverName).isEqualTo("Docker")
    }

    @Test
    fun servicesApplied() {
        settingsApplier.apply(DockerComposeConfigurationSettings(
            name = "Docker Compose Services",
            services = listOf("service1")))
        assertThat(getDockerDeploymentConfiguration("Docker Compose Services").services).containsExactly("service1")
    }

    @Test
    fun composeFilesApplied() {
        settingsApplier.apply(DockerComposeConfigurationSettings(
            name = "Docker Compose Files",
            composeFiles = listOf(
                File(project.basePath).resolve("docker-compose.yml"),
                File(project.basePath).resolve("docker-compose-2.yml"),
                File(project.basePath).resolve("docker-compose-3.yml"))))
        assertThat(getDockerDeploymentConfiguration("Docker Compose Files").sourceFilePath)
                .isEqualTo(Paths.get(project.basePath).resolve("docker-compose.yml").toString())
        assertThat(getDockerDeploymentConfiguration("Docker Compose Files").secondarySourceFiles)
                .containsExactly(
                        Paths.get(project.basePath).resolve("docker-compose-2.yml").toString(),
                        Paths.get(project.basePath).resolve("docker-compose-3.yml").toString())
    }

    @Test
    fun environmentVariablesApplied() {
        settingsApplier.apply(DockerComposeConfigurationSettings(
            name = "Docker Compose Environment Variables",
            environmentVariables = listOf(EnvironmentVariable(name = "name", value = "value"))))
        assertThat(getDockerDeploymentConfiguration("Docker Compose Environment Variables").envVars)
                .containsExactly(DockerEnvVarImpl("name", "value"))
    }

    @Test
    fun forceBuildApplied() {
        settingsApplier.apply(DockerComposeConfigurationSettings(
            name = "Docker Compose Force Build",
            options = DockerComposeConfigurationOptionsSettings(
                buildForceBuildImages = true)))
        assertThat(getDockerDeploymentConfiguration("Docker Compose Force Build").runCliOptions)
                .isEqualTo("--build")
    }

    private fun getDockerDeploymentConfiguration(name: String): DockerDeploymentConfiguration {
        val runnerAndConfigurationSettings = platform.runManager.findConfigurationByName(name)
        assertThat(runnerAndConfigurationSettings).isNotNull()
        val deployToServerRunConfiguration = runnerAndConfigurationSettings!!.configuration as DeployToServerRunConfiguration<*, *>
        return deployToServerRunConfiguration.deploymentConfiguration as DockerDeploymentConfiguration
    }
}
