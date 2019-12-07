package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

import com.fasterxml.jackson.annotation.JsonProperty
import java.nio.file.Path

data class RunMavenGoalSettings(

    @JsonProperty("Working directory")
    val workingDirectory: Path,

    @JsonProperty("Command line")
    val commandLine: String
) : BeforeLaunchConfigurationSettings
