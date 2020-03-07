package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettings

typealias EslintInspectionSettings = BaseInspectionSettings<EslintInspectionOptionsSettings>

data class JavascriptCodeQualityToolsInspectionsSettings(

    @JsonProperty("ESLint")
    val eslint: EslintInspectionSettings? = null
)
