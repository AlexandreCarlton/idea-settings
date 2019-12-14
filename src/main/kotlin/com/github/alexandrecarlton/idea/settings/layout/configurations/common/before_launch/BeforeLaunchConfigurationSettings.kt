package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo.As
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import com.fasterxml.jackson.annotation.JsonTypeName
import java.nio.file.Path

@JsonTypeInfo(use = Id.NAME, include = As.WRAPPER_OBJECT)
sealed class BeforeLaunchConfigurationSettings

@JsonTypeName("Build")
object BuildConfigurationSettings : BeforeLaunchConfigurationSettings()

@JsonTypeName("Run Another Configuration")
data class RunAnotherConfigurationSettings(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Type")
    val type: RunConfigurationType? = null

) : BeforeLaunchConfigurationSettings()

@JsonTypeName("Run Maven Goal")
data class RunMavenGoalSettings(

    @JsonProperty("Working directory")
    val workingDirectory: Path,

    @JsonProperty("Command line")
    val commandLine: String

) : BeforeLaunchConfigurationSettings()

