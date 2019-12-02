package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

import java.nio.file.Path

data class RunMavenGoalSettings(
    val workingDirectory: Path,
    val commandLine: String
) : BeforeLaunchConfigurationSettings
