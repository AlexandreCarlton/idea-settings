package com.github.alexandrecarlton.idea.settings.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.MissingDeprecatedAnnotationInspectionOptionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.EslintInspectionOptionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.MissingDeprecatedAnnotationInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.EslintInspectionOptionsSettings
import dagger.Binds
import dagger.Module

@Module
interface InspectionOptionsSettingsApplierModule {

    @Binds
    fun provideInspectionOptionsSettingsApplier(applier: InspectionOptionsSettingsApplier): SettingsApplier<Any>

    @Binds
    fun provideEslintInspectionOptionsSettingsApplier(applier: EslintInspectionOptionsSettingsApplier): SettingsApplier<EslintInspectionOptionsSettings>

    @Binds
    fun provideMissingDeprecatedAnnotationInspectionOptionsSettingsApplier(applier: MissingDeprecatedAnnotationInspectionOptionsSettingsApplier): SettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryParenthesesInspectionOptionsSettingsApplier(applier: UnnecessaryParenthesesInspectionOptionsSettingsApplier): SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>

}

