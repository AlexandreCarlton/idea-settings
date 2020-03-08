package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.options

import com.fasterxml.jackson.annotation.JsonProperty

data class EslintInspectionOptionsSettings(
    @JsonProperty("Use rule severity from the configuration file JavaScript / Code Quality Tools / ESLint")
    val useRuleSeverityFromTheConfigurationFile: Boolean? = null
)
