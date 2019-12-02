package com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle

data class CheckstyleSettings(

    val checkstyleVersion: String? = null,

    val scanScope: CheckstyleScanScope? = null,

    val treatCheckstyleErrorsAsWarnings: Boolean? = null,

    val configurationFiles: List<CheckstyleConfigurationFile>? = null
)
