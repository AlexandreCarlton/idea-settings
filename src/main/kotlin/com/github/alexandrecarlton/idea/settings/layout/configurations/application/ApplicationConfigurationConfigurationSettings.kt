package com.github.alexandrecarlton.idea.settings.layout.configurations.application

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class ApplicationConfigurationConfigurationSettings(

    @JsonProperty("Main class")
    val mainClass: String,

    @JsonProperty("VM options")
    val vmOptions: String? = null,

    @JsonProperty("Program arguments")
    val programArguments: String? = null,

    @JsonProperty("Working directory")
    val workingDirectory: File? = null,

    @JsonProperty("Use classpath of module")
    val useClassPathOfModule: String
)
