package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettings

data class JavascriptSettings(
    @JsonProperty("JavaScript language version")
    val javascriptLanguageVersion: JavascriptLanguageVersion? = null,

    @JsonProperty("Code Quality Tools")
    val codeQualityTools: JavascriptCodeQualityToolsSettings? = null
)
