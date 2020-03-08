package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaCodeStyleIssuesInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideJavaCodeStyleIssuesInspectionsSettingsApplier(applier: Lazy<JavaCodeStyleIssuesInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideUnnecessaryCallToSuperInspectionSettingsApplier(applier: Lazy<UnnecessaryCallToSuperInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideUnnecessaryParenthesesInspectionSettingsApplier(applier: Lazy<UnnecessaryParenthesesInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideUnnecessaryQualifierForThisOrSuperInspectionSettingsApplier(applier: Lazy<UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
