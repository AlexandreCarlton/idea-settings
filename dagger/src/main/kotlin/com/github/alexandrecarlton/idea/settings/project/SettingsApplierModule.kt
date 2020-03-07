package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.InspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.InspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.JavadocInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.JavadocInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface SettingsApplierModule {

    @Binds
    fun bindInspectionsSettingsApplier(applier: InspectionsSettingsApplier): SettingsApplier<InspectionsSettings>

    @Binds
    fun bindJavaCodeStyleIssuesInspectionsSettingsApplier(applier: JavaCodeStyleIssuesInspectionsSettingsApplier): SettingsApplier<JavaCodeStyleIssuesInspectionsSettings>

    @Binds
    fun bindJavadocInspectionsSettingsApplier(applier: JavadocInspectionsSettingsApplier): SettingsApplier<JavadocInspectionsSettings>

    @Binds
    fun bindJavaProbableBugsInspectionsSettingsApplier(applier: JavaProbableBugsInspectionsSettingsApplier): SettingsApplier<JavaProbableBugsInspectionsSettings>

    @Binds
    fun bindJavascriptCodeQualityToolsInspectionsSettingsApplier(applier: JavascriptCodeQualityToolsInspectionsSettingsApplier): SettingsApplier<JavascriptCodeQualityToolsInspectionsSettings>

}
