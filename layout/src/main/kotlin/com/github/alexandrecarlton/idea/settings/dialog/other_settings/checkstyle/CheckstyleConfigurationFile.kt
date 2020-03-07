package com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle

import com.fasterxml.jackson.annotation.JsonProperty

data class CheckstyleConfigurationFile(

    @JsonProperty("Active")
    val active: Boolean = false,

    @JsonProperty("Description")
    val description: String,

    @JsonProperty("File")
    val file: String
)
