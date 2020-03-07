package com.github.alexandrecarlton.idea.settings.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.probable_bugs.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings
import dagger.Binds
import dagger.Module

// TODO: stick this in a noop package, alongside NoOpInspectionOptionssettingsApplier
@Module
interface NoOpInspectionOptionsSettingsApplierModule {

    @Binds
    fun provideArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings(applier: NoOpInspectionOptionsSettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>): SettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplier(applier: NoOpInspectionOptionsSettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryCallToSuperInspectionOptionsSettingsApplier(applier: NoOpInspectionOptionsSettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>
}
