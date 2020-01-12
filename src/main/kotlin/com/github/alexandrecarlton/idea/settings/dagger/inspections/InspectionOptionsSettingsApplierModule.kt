package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module
interface InspectionOptionsSettingsApplierModule {

    @Binds
    fun provideInspectionOptionsSettingsApplier(applier: InspectionOptionsSettingsApplier): SettingsApplier<Any>

    @Binds
    fun provideUnnecessaryCallToSuperInspectionOptionsSettingsApplier(applier: NoOpInspectionOptionsSettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryParenthesesInspectionOptionsSettingsApplier(applier: UnnecessaryParenthesesInspectionOptionsSettingsApplier): SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>

    @Binds
    fun provideUnnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplier(applier: NoOpInspectionOptionsSettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>): SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>

}

