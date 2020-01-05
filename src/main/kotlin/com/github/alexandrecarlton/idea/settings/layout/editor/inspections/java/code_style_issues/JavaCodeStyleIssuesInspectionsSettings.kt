package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.BaseInspectionSettings

// if we use 'Unit', we will wind up with a duplicate binding; so we create distinct options types
// TODO: Turn this into a sealed class: InspectionOptionsSettings?
object UnnecessaryCallToSuperInspectionOptionsSettings
typealias UnnecessaryCallToSuperInspectionSettings = BaseInspectionSettings<UnnecessaryCallToSuperInspectionOptionsSettings>

typealias UnnecessaryParenthesesInspectionSettings = BaseInspectionSettings<UnnecessaryParenthesesInspectionOptionsSettings>

object UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
typealias UnnecessaryQualifierForThisOrSuperInspectionSettings = BaseInspectionSettings<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>

data class JavaCodeStyleIssuesInspectionsSettings(

    @JsonProperty("Unnecessary call to 'super()'")
    val unnecessaryCallToSuper: UnnecessaryCallToSuperInspectionSettings? = null,

    @JsonProperty("Unnecessary qualifier for 'this' or 'super'")
    val unnecessaryQualifierForThisOrSuper: UnnecessaryQualifierForThisOrSuperInspectionSettings? = null,

    @JsonProperty("Unnecessary parentheses")
    val unnecessaryParenthesesInspection: UnnecessaryParenthesesInspectionSettings? = null
)
