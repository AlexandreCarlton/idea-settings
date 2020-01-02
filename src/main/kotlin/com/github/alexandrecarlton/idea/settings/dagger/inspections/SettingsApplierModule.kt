package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import dagger.Binds
import dagger.Module

@Module
interface SettingsApplierModule {

    @Binds
    fun provideUnnecessaryParenthesesInspectionOptionsSettingsApplier(applier: UnnecessaryParenthesesInspectionOptionsSettingsApplier): SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>

}
