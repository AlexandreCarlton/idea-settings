package com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class CheckstyleSettings(

    @JsonProperty("Checkstyle version")
    val checkstyleVersion: String? = null,

    @JsonProperty("Scan Scope")
    val scanScope: CheckstyleScanScope? = null,

    @JsonProperty("Treat Checkstyle errors as warnings")
    val treatCheckstyleErrorsAsWarnings: Boolean? = null,

    @JsonProperty("Configuration files")
    val configurationFiles: List<CheckstyleConfigurationFile>? = null,

    @JsonProperty("Third-Party Checks")
    val thirdPartyChecks: List<File>? = null
)
