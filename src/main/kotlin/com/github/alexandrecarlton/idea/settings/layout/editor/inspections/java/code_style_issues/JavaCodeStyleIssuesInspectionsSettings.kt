package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.BaseInspectionSettings

typealias UnnecessaryCallToSuperInspectionSettings = BaseInspectionSettings<UnnecessaryCallToSuperInspectionOptionsSettings>
typealias UnnecessaryParenthesesInspectionSettings = BaseInspectionSettings<UnnecessaryParenthesesInspectionOptionsSettings>
typealias UnnecessaryQualifierForThisOrSuperInspectionSettings = BaseInspectionSettings<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>

data class JavaCodeStyleIssuesInspectionsSettings(

    @JsonProperty("Unnecessary call to 'super()'")
    val unnecessaryCallToSuper: UnnecessaryCallToSuperInspectionSettings? = null,

    @JsonProperty("Unnecessary qualifier for 'this' or 'super'")
    val unnecessaryQualifierForThisOrSuper: UnnecessaryQualifierForThisOrSuperInspectionSettings? = null,

    @JsonProperty("Unnecessary parentheses")
    val unnecessaryParenthesesInspection: UnnecessaryParenthesesInspectionSettings? = null
)
