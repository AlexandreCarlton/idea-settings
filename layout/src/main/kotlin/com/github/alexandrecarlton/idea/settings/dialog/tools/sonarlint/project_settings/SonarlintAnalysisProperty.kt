package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonProperty

data class SonarlintAnalysisProperty(

    @JsonProperty("Property Name")
    val propertyName: String? = null,

    @JsonProperty("Value")
    val value: String? = null
)
