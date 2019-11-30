package com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle

data class CheckstyleConfigurationFile(
    val active: Boolean = false,

    val description: String,

    val file: String
)
