package com.github.alexandrecarlton.idea.settings.layout.other_settings

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings

data class OtherSettings(
    @JsonProperty("Checkstyle")
    val checkstyle: CheckstyleSettings? = null
)
