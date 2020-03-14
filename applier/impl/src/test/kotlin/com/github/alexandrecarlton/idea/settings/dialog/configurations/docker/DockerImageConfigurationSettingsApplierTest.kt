package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment.EnvironmentVariable
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.docker.agent.settings.DockerPortBindingImpl
import com.intellij.execution.RunManager
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class DockerImageConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var dockerRunConfigurationCreator: DockerRunConfigurationCreator
    private lateinit var settingsApplier: SettingsApplier<DockerImageConfigurationSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        dockerRunConfigurationCreator = DockerRunConfigurationCreator(project)
        runManager = RunManager.getInstance(project)
        settingsApplier = DockerImageConfigurationSettingsApplier(dockerRunConfigurationCreator, runManager)
    }

    @Test
    fun serverApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(
            name = "Image Server",
            server = "Docker"))
        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Image Server")
        val deployToServerRunConfiguration = runnerAndConfigurationSettings!!.configuration as DeployToServerRunConfiguration<*, *>
        assertThat(deployToServerRunConfiguration.serverName).isEqualTo("Docker")
    }

    @Test
    fun imageIdApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(name = "Image ID", imageId = "hello-world"))
        assertThat(getDockerDeploymentConfiguration("Image ID").imageTag).isEqualTo("hello-world")
    }

    @Test
    fun containerNameApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(name = "Container Name", containerName = "container-name"))
        assertThat(getDockerDeploymentConfiguration("Container Name").containerName).isEqualTo("container-name")
    }

    @Test
    fun publishtToHostInterfaceApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(
            name = "Publish all",
            publishExposedPortsToTheHostInterfaces = DockerPublishToHostInterface.ALL))
        assertThat(getDockerDeploymentConfiguration("Publish all").isPublishAllPorts).isTrue()
    }

    @Test
    fun executableApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(
            name = "Executable",
            executable = DockerExecutableSettings(
                command = "command",
                entrypoint = "/bin/entrypoint")))
        assertThat(getDockerDeploymentConfiguration("Executable").entrypoint).isEqualTo("/bin/entrypoint")
        assertThat(getDockerDeploymentConfiguration("Executable").command).isEqualTo("command")
    }

    @Test
    fun portBindingApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(
                name ="Port Binding",
                bindPorts = listOf(DockerPortBinding(
                    containerPort = 1234,
                    hostPort = 5678,
                    hostIp = "1.2.3.4",
                    protocol = DockerPortBindingProtocol.TCP))))
        val expectedDockerPortBindingImpl = DockerPortBindingImpl().apply {
            containerPort = 1234
            hostPort = 5678
            hostIp = "1.2.3.4"
            protocol = "tcp"
        }
        assertThat(getDockerDeploymentConfiguration("Port Binding").portBindings)
                .containsExactly(expectedDockerPortBindingImpl)
    }

    @Test
    fun environmentVariablesApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(
                name = "Environment Variables",
                environmentVariables = listOf(EnvironmentVariable(
                    name = "name", value = "value"))))
        assertThat(getDockerDeploymentConfiguration("Environment Variables").envVars)
                .containsExactly(DockerEnvVarImpl("name", "value"))
    }

    @Test
    fun runOptionsApplied() {
        settingsApplier.apply(DockerImageConfigurationSettings(name = "Run Options", runOptions = "--rm -it"))
        assertThat(getDockerDeploymentConfiguration("Run Options").runCliOptions).isEqualTo("--rm -it")
    }

    private fun getDockerDeploymentConfiguration(name: String): DockerDeploymentConfiguration {
        val runnerAndConfigurationSettings = runManager.findConfigurationByName(name)!!
        val deployToServerRunConfiguration = runnerAndConfigurationSettings.configuration as DeployToServerRunConfiguration<*, *>
        return deployToServerRunConfiguration.deploymentConfiguration as DockerDeploymentConfiguration
    }
}
