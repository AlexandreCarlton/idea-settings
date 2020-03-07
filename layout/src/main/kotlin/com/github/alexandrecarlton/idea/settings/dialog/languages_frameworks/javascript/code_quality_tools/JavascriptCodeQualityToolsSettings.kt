package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettings

data class JavascriptCodeQualityToolsSettings(
    @JsonProperty("ESLint")
    val eslint: EslintSettings? = null
)
