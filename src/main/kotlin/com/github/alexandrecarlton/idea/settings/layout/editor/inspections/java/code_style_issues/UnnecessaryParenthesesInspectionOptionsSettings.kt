package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues

import com.fasterxml.jackson.annotation.JsonProperty

data class UnnecessaryParenthesesInspectionOptionsSettings(

    @JsonProperty("Ignore clarifying parentheses")
    val ignoreClarifyingPatterns: Boolean? = null,

    @JsonProperty("Ignore parentheses around the condition of conditional expressions")
    val ignoreParenthesesAroundTheConditionOfConditionalExpressions: Boolean? = null,

    @JsonProperty("Ignore parentheses around single no formal type lambda parameter")
    val ignoreParenthesesAroundSingleNoFormalTypeLambdaParameter: Boolean? = null
)
