package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBindingProtocol
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerEnvironmentVariable
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerExecutableSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.ImmutableDockerPortBinding
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
    fun imageIdApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Image ID")
                .imageId("hello-world")
                .build())
        assertThat(getDockerDeploymentConfiguration("Image ID").imageTag).isEqualTo("hello-world")
    }

    @Test
    fun containerNameApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Container Name")
                .containerName("container-name")
                .build())
        assertThat(getDockerDeploymentConfiguration("Container Name").containerName).isEqualTo("container-name")
    }

    @Test
    fun publishtToHostInterfaceApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Publish all")
                .publishExposedPortsToTheHostInterfaces(DockerPublishToHostInterface.ALL)
                .build())
        assertThat(getDockerDeploymentConfiguration("Publish all").isPublishAllPorts).isTrue()
    }

    @Test
    fun executableApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Executable")
                .executable(ImmutableDockerExecutableSettings.builder()
                        .command("command")
                        .entrypoint("/bin/entrypoint")
                        .build())
                .build())
        assertThat(getDockerDeploymentConfiguration("Executable").entrypoint).isEqualTo("/bin/entrypoint")
        assertThat(getDockerDeploymentConfiguration("Executable").command).isEqualTo("command")
    }

    @Test
    fun portBindingApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Port Binding")
                .bindPorts(listOf(
                        ImmutableDockerPortBinding.builder()
                                .containerPort(1234)
                                .hostPort(5678)
                                .hostIp("1.2.3.4")
                                .protocol(DockerPortBindingProtocol.TCP)
                                .build()))
                .build())
        val expectedDockerPortBindingImpl = DockerPortBindingImpl()
        expectedDockerPortBindingImpl.containerPort = 1234
        expectedDockerPortBindingImpl.hostPort = 5678
        expectedDockerPortBindingImpl.hostIp = "1.2.3.4"
        expectedDockerPortBindingImpl.protocol = "tcp"
        assertThat(getDockerDeploymentConfiguration("Port Binding").portBindings)
                .containsExactly(expectedDockerPortBindingImpl)
    }

    @Test
    fun environmentVariablesApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Environment Variables")
                .environmentVariables(listOf(
                        ImmutableDockerEnvironmentVariable.builder()
                                .name("name")
                                .value("value")
                                .build()))
                .build())
        assertThat(getDockerDeploymentConfiguration("Environment Variables").envVars)
                .containsExactly(DockerEnvVarImpl("name", "value"))
    }

    @Test
    fun runOptionsApplied() {
        settingsApplier.apply(ImmutableDockerImageConfigurationSettings.builder()
                .name("Run Options")
                .runOptions("--rm -it")
                .build())
        assertThat(getDockerDeploymentConfiguration("Run Options").runCliOptions)
                .isEqualTo("--rm -it")
    }

    private fun getDockerDeploymentConfiguration(name: String): DockerDeploymentConfiguration {
        val runnerAndConfigurationSettings = runManager.findConfigurationByName(name)
        assertThat(runnerAndConfigurationSettings).isNotNull()
        val deployToServerRunConfiguration = runnerAndConfigurationSettings!!.configuration as DeployToServerRunConfiguration<*, *>
        return deployToServerRunConfiguration.deploymentConfiguration as DockerDeploymentConfiguration
    }
}
