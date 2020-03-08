package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.noop.NoOpSettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface NoOpJavaCodeStyleIssuesInspectionsOptionsModule {

    @Binds
    fun provideUnnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplier(applier: NoOpSettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryCallToSuperInspectionOptionsSettingsApplier(applier: NoOpSettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>
}
