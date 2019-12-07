package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import java.nio.file.Path

data class ShellScriptConfigurationSettings(

    @JsonProperty("Name")
    override val name: String,

    @JsonProperty("Share through VCS")
    override val shareThroughVcs: Boolean? = null,

    @JsonProperty("Before launch")
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Script path")
    val scriptPath: Path,

    @JsonProperty("Script options")
    val scriptOptions: String? = null,

    @JsonProperty("Interpreter")
    val interpreter: InterpreterConfigurationSettings? = null
) : ConfigurationSettings
