package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script

import com.fasterxml.jackson.annotation.JsonProperty
import java.nio.file.Path

data class InterpreterConfigurationSettings(

    @JsonProperty("Interpreter path")
    val interpreterPath: Path? = null,

    @JsonProperty("Interpreter options")
    val interpreterOptions: String? = null
)
