package com.github.alexandrecarlton.idea.settings.layout.configurations.application

import java.nio.file.Path

data class ApplicationConfigurationConfigurationSettings(

    val mainClass: String,

    val vmOptions: String? = null,

    val programArguments: String? = null,

    val workingDirectory: Path? = null,

    val useClassPathOfModule: String
)
