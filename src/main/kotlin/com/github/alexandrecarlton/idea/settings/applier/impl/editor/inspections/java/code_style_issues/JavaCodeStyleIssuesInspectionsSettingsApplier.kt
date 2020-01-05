package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionSettings
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
