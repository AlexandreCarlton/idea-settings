package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.JavadocInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsSettings
import javax.inject.Inject

class JavaInspectionsSettingsApplier @Inject
constructor(
    private val javaCodeStyleIssuesInspectionsSettingsApplier: SettingsApplier<JavaCodeStyleIssuesInspectionsSettings>,
    private val javadocInspectionsSettingsApplier: SettingsApplier<JavadocInspectionsSettings>,
    private val javaProbableBugsInspectionsSettingsApplier: SettingsApplier<JavaProbableBugsInspectionsSettings>
): SettingsApplier<JavaInspectionsSettings> {
    override fun apply(settings: JavaInspectionsSettings) {
        settings.codeStyleIssues?.let(javaCodeStyleIssuesInspectionsSettingsApplier::apply)
        settings.javadoc?.let(javadocInspectionsSettingsApplier::apply)
        settings.probableBugs?.let(javaProbableBugsInspectionsSettingsApplier::apply)
    }
}
