package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript

import com.fasterxml.jackson.annotation.JsonProperty

data class JavascriptSettings(
    @JsonProperty("JavaScript language version")
    val javascriptLanguageVersion: JavascriptLanguageVersion? = null
)
