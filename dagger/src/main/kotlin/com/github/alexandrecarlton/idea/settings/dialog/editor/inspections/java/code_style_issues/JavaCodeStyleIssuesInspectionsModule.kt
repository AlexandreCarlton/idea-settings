package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaCodeStyleIssuesInspectionsModule : AbstractPluginModule() {

    @Provides
    internal fun provide(applier: Lazy<JavaCodeStyleIssuesInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    internal fun provideUnnecessaryCallToSuperInspectionSettingsApplier(applier: Lazy<UnnecessaryCallToSuperInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    internal fun provideUnnecessaryParenthesesInspectionSettingsApplier(applier: Lazy<UnnecessaryParenthesesInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    internal fun provideUnnecessaryQualifierForThisOrSuperInspectionSettingsApplier(applier: Lazy<UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
