package com.github.alexandrecarlton.idea.settings.dialog.configurations

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.github.alexandrecarlton.idea.settings.dialog.configurations.application.ApplicationConfigurationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment.EnvironmentVariable
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerComposeConfigurationOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerExecutableSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerPortBinding
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerPublishToHostInterface
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand
import com.github.alexandrecarlton.idea.settings.dialog.configurations.remote.RemoteConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootConfigurationSettings
import java.io.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class ConfigurationSettings(

    @get:JsonProperty("Name")
    open val name: String,

    @get:JsonProperty("Store as project file")
    open val storeAsProjectFile: Boolean?,

    // TODO: Currently unsupported
    @get:JsonProperty("Store configuration file in - TODO")
    open val storeConfigurationFileIn: File?,

    @get:JsonProperty("Before launch")
    open val beforeLaunch: List<BeforeLaunchConfigurationSettings>?
)

@JsonTypeName("Application")
data class ApplicationConfigurationSettings(

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: ApplicationConfigurationConfigurationSettings

) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)

@JsonTypeName("Docker-compose")
data class DockerComposeConfigurationSettings(

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Server")
    val server: String? = null,

    @JsonProperty("Compose file(s)")
    val composeFiles: List<File>? = null,

    @JsonProperty("Service(s)")
    val services: List<String>? = null,

    @JsonProperty("Environment variables")
    val environmentVariables: List<EnvironmentVariable>? = null,

    @JsonProperty("Options")
    val options: DockerComposeConfigurationOptionsSettings? = null
) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)

@JsonTypeName("Docker Image")
data class DockerImageConfigurationSettings(

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
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
    val environmentVariables: List<EnvironmentVariable>? = null,

    @JsonProperty("Run options")
    val runOptions: String? = null

) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)

@JsonTypeName("npm")
data class NpmConfigurationSettings (

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("package.json")
    val packageJson: File? = null,

    @JsonProperty("Command")
    val command: NpmConfigurationCommand? = null,

    /**
     * Should only be used if the command is 'run'.
     */
    @JsonProperty("Scripts")
    val scripts: String? = null,

    @JsonProperty("Arguments")
    val arguments: String? = null,

    @JsonProperty("Node interpreter")
    val nodeInterpreter: File? = null,

    @JsonProperty("Node options")
    val nodeOptions: String? = null,

    @JsonProperty("Package manager")
    val packageManager: File? = null,

    @JsonProperty("")
    val environment: List<EnvironmentVariable>? = null

) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)

@JsonTypeName("Remote")
data class RemoteSettings (

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: RemoteConfigurationSettings? = null
) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)

@JsonTypeName("Spring Boot")
data class SpringBootSettings (

    override val name: String,
    override val storeAsProjectFile: Boolean? = null,
    override val storeConfigurationFileIn: File? = null,
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: SpringBootConfigurationSettings
) : ConfigurationSettings(name, storeAsProjectFile, storeConfigurationFileIn, beforeLaunch)
