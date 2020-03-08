package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module(includes = [NoOpJavaCodeStyleIssuesInspectionsOptionsModule::class])
object JavaCodeStyleIssuesInspectionsOptionsModule : AbstractPluginModule() {

    @Provides
    fun provideUnnecessaryParenthesesInspectionOptionsSettingsApplier(applier: Lazy<UnnecessaryParenthesesInspectionOptionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
