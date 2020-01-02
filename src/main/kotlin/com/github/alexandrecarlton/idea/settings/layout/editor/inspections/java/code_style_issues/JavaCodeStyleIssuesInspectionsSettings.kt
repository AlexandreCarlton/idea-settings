package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.BaseInspectionSettings

typealias UnnecessaryQualifierForThisOrSuperInspectionSettings = BaseInspectionSettings<Unit>
typealias UnnecessaryParenthesesInspectionSettings = BaseInspectionSettings<UnnecessaryParenthesesInspectionOptionsSettings>

data class JavaCodeStyleIssuesInspectionsSettings(
    @JsonProperty("Unnecessary qualifier for 'this' or 'super'")
    val unnecessaryQualifierForThisOrSuper: UnnecessaryQualifierForThisOrSuperInspectionSettings? = null,

    @JsonProperty("Unnecessary parentheses")
    val unnecessaryParenthesesInspection: UnnecessaryParenthesesInspectionSettings? = null
)
