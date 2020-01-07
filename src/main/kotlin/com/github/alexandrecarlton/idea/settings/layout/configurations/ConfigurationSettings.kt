package com.github.alexandrecarlton.idea.settings.layout.configurations

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.github.alexandrecarlton.idea.settings.layout.configurations.application.ApplicationConfigurationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerEnvironmentVariable
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerExecutableSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBinding
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.InterpreterConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationSettings
import java.io.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class ConfigurationSettings(

    @get:JsonProperty("Name")
    open val name: String,

    @get:JsonProperty("Share through VCS")
    open val shareThroughVcs: Boolean?,

    @get:JsonProperty("Before launch")
    open val beforeLaunch: List<BeforeLaunchConfigurationSettings>?
)

@JsonTypeName("Application")
data class ApplicationConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: ApplicationConfigurationConfigurationSettings

) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)

@JsonTypeName("Docker-compose")
data class DockerComposeConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Server")
    val server: String? = null,

    @JsonProperty("Compose file(s)")
    val composeFiles: List<File>? = null,

    @JsonProperty("Service(s)")
    val services: List<String>? = null,

    @JsonProperty("Environment variables")
    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    @JsonProperty("Options")
    val options: DockerComposeConfigurationOptionsSettings? = null
) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)

@JsonTypeName("Docker Image")
data class DockerImageConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Server")
    val server: String? = null,

    @JsonProperty("Image ID")
    val imageId: String? = null,

    @JsonProperty("Container name")
    val containerName: String? = null,

    @JsonProperty("Publish exposed ports to the host interfaces")
    val publishExposedPortsToTheHostInterfaces: DockerPublishToHostInterface? = null,

    @JsonProperty("Executable")
    val executable: DockerExecutableSettings? = null,

    @JsonProperty("Bind ports")
    val bindPorts: List<DockerPortBinding>? = null,

    // TODO: bindMounts

    @JsonProperty("Environment variables")
    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    @JsonProperty("Run options")
    val runOptions: String? = null

) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)

@JsonTypeName("Remote")
data class RemoteSettings (

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: RemoteConfigurationSettings? = null
) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)

@JsonTypeName("Shell Script")
data class ShellScriptConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Script path")
    val scriptPath: File,

    @JsonProperty("Script options")
    val scriptOptions: String? = null,

    @JsonProperty("Interpreter")
    val interpreter: InterpreterConfigurationSettings? = null
) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)

@JsonTypeName("Spring Boot")
data class SpringBootSettings (

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: SpringBootConfigurationSettings
) : ConfigurationSettings(name, shareThroughVcs, beforeLaunch)
