package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools

import com.fasterxml.jackson.annotation.JsonProperty

data class EslintInspectionOptionsSettings(
    @JsonProperty("Use rule severity from the configuration file JavaScript / Code Quality Tools / ESLint")
    val useRuleSeverityFromTheConfigurationFile: Boolean? = null
)
