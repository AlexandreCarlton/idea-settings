package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class JavaCodeStyleIssuesInspectionsSettingsApplier @Inject
constructor(
    private val unnecessaryCallToSuperInspectionSettingsApplier: SettingsApplier<UnnecessaryCallToSuperInspectionSettings>,
    private val unnecessaryQualifierForThisOrSuperInspectionSettingsApplier: SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionSettings>,
    private val unnecessaryParenthesesInspectionSettingsApplier: SettingsApplier<UnnecessaryParenthesesInspectionSettings>
): SettingsApplier<JavaCodeStyleIssuesInspectionsSettings> {
    override fun apply(settings: JavaCodeStyleIssuesInspectionsSettings) {
        settings.unnecessaryParenthesesInspection?.let(unnecessaryParenthesesInspectionSettingsApplier::apply)
        settings.unnecessaryQualifierForThisOrSuper?.let(unnecessaryQualifierForThisOrSuperInspectionSettingsApplier::apply)
        settings.unnecessaryCallToSuper?.let(unnecessaryCallToSuperInspectionSettingsApplier::apply)
    }
}
