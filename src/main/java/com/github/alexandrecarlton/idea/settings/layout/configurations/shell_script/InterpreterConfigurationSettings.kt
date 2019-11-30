package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script

import java.nio.file.Path

data class InterpreterConfigurationSettings(

    val interpreterPath: Path? = null,

    val interpreterOptions: String? = null
)
