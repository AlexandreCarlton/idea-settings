package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.BaseInspectionSettings

typealias EslintInspectionSettings = BaseInspectionSettings<EslintInspectionOptionsSettings>

data class JavascriptCodeQualityToolsInspectionsSettings(

    @JsonProperty("ESLint")
    val eslint: EslintInspectionSettings? = null
)
