package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettings

data class JavascriptInspectionsSettings(
    @JsonProperty("Code quality tools")
    val codeQualityTools: JavascriptCodeQualityToolsInspectionsSettings? = null
)
