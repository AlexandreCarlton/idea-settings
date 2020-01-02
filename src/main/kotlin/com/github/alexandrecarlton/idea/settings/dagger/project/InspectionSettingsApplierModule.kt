package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionSettings
import com.intellij.codeInspection.ex.ToolsImpl
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Named


class UnnecessaryParenthesesInspectionSettingsApplier @Inject constructor(@Named("UnnecessaryParentheses") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>(toolsImpl)
class UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier @Inject constructor(@Named("UnnecessaryQualifierForThis") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<Unit>(toolsImpl)

/**
 * All inspections here inherit from [BaseInspectionSettingsApplier] (declared above),
 * parameterised on the options data class.
 */
@Module
interface InspectionSettingsApplierModule {

    @Binds
    fun provideUnnecessaryParenthesesInspectionSettingsApplier(applier: UnnecessaryParenthesesInspectionSettingsApplier): SettingsApplier<UnnecessaryParenthesesInspectionSettings>

    @Binds
    fun provideUnnecessaryQualifierForThisOrSuperInspectionSettingsApplier(applier: UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier): SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionSettings>
}
