package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import java.nio.file.Path

data class ShellScriptConfigurationSettings (
    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    val scriptPath: Path,

    val scriptOptions: String? = null,

    val interpreter: InterpreterConfigurationSettings? = null
) : ConfigurationSettings
