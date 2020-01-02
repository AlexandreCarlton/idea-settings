package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.JavaInspectionsSettings
import javax.inject.Inject

class JavaInspectionsSettingsApplier @Inject
constructor(
    private val javaCodeStyleIssuesInspectionsSettingsApplier: SettingsApplier<JavaCodeStyleIssuesInspectionsSettings>
): SettingsApplier<JavaInspectionsSettings> {
    override fun apply(settings: JavaInspectionsSettings) {
        settings.codeStyleIssues?.let(javaCodeStyleIssuesInspectionsSettingsApplier::apply)
    }
}
