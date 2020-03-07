package com.github.alexandrecarlton.idea.settings.dialog.configurations.shell_script

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class InterpreterConfigurationSettings(

    @JsonProperty("Interpreter path")
    val interpreterPath: File? = null,

    @JsonProperty("Interpreter options")
    val interpreterOptions: String? = null
)
