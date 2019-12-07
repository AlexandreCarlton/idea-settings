package com.github.alexandrecarlton.idea.settings.layout.configurations

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.alexandrecarlton.idea.settings.layout.configurations.application.ApplicationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings

// TODO: Look into sealed classes
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes(
    Type(name = "Application", value = ApplicationConfigurationSettings::class),
    Type(name = "Docker-compose", value = DockerComposeConfigurationSettings::class),
    Type(name = "Docker Image", value = DockerImageConfigurationSettings::class),
    Type(name = "Remote", value = RemoteSettings::class),
    Type(name = "Shell Script", value = ShellScriptConfigurationSettings::class),
    Type(name = "Spring Boot", value = SpringBootSettings::class))
interface ConfigurationSettings {

    val name: String

    val shareThroughVcs: Boolean?

    val beforeLaunch: List<BeforeLaunchConfigurationSettings>?
}
