package com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle

import com.fasterxml.jackson.annotation.JsonProperty

data class CheckstyleSettings(

    @JsonProperty("Checkstyle version")
    val checkstyleVersion: String? = null,

    @JsonProperty("Scan Scope")
    val scanScope: CheckstyleScanScope? = null,

    @JsonProperty("Treat Checkstyle errors as warnings")
    val treatCheckstyleErrorsAsWarnings: Boolean? = null,

    @JsonProperty("Configuration files")
    val configurationFiles: List<CheckstyleConfigurationFile>? = null
)
