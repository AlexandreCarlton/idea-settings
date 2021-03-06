package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options

import com.fasterxml.jackson.annotation.JsonProperty

data class UnnecessaryParenthesesInspectionOptionsSettings(

    @JsonProperty("Ignore clarifying parentheses")
    val ignoreClarifyingPatterns: Boolean? = null,

    @JsonProperty("Ignore parentheses around the condition of conditional expressions")
    val ignoreParenthesesAroundTheConditionOfConditionalExpressions: Boolean? = null,

    @JsonProperty("Ignore parentheses around single no formal type lambda parameter")
    val ignoreParenthesesAroundSingleNoFormalTypeLambdaParameter: Boolean? = null
)
