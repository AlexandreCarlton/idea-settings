package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.javadoc.MissingDeprecatedAnnotationInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.javadoc.MissingDeprecatedAnnotationInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.probable_bugs.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.probable_bugs.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.EslintInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.EslintInspectionSettings
import com.intellij.codeInspection.ex.ToolsImpl
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Named


// Should be able to generate these.
class ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier @Inject constructor(@Named("ArrayEquality") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>(toolsImpl)
class EslintInspectionSettingsApplier @Inject constructor(@Named("Eslint") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<EslintInspectionOptionsSettings>(toolsImpl)
class MissingDeprecatedAnnotationInspectionSettingsApplier @Inject constructor(@Named("MissingDeprecatedAnnotation") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings>(toolsImpl)
class UnnecessaryCallToSuperInspectionSettingsApplier @Inject constructor(@Named("UnnecessarySuperConstructor") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>(toolsImpl)
class UnnecessaryParenthesesInspectionSettingsApplier @Inject constructor(@Named("UnnecessaryParentheses") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>(toolsImpl)
class UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier @Inject constructor(@Named("UnnecessaryQualifierForThis") toolsImpl: ToolsImpl) : BaseInspectionSettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>(toolsImpl)

/**
 * All inspections here inherit from [BaseInspectionSettingsApplier] (declared above),
 * parameterised on the options data class.
 */
@Module
interface InspectionSettingsApplierModule {

    @Binds
    fun provideArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier(applier: ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier): SettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings>

    @Binds
    fun provideEslintInspectionSettingsApplier(applier: EslintInspectionSettingsApplier): SettingsApplier<EslintInspectionSettings>

    @Binds
    fun provideMissingDeprecatedAnnotationInspectionOptionsSettings(applier: MissingDeprecatedAnnotationInspectionSettingsApplier): SettingsApplier<MissingDeprecatedAnnotationInspectionSettings>

    @Binds
    fun provideUnnecessaryCallToSuperInspectionSettingsApplier(applier: UnnecessaryCallToSuperInspectionSettingsApplier): SettingsApplier<UnnecessaryCallToSuperInspectionSettings>

    @Binds
    fun provideUnnecessaryParenthesesInspectionSettingsApplier(applier: UnnecessaryParenthesesInspectionSettingsApplier): SettingsApplier<UnnecessaryParenthesesInspectionSettings>

    @Binds
    fun provideUnnecessaryQualifierForThisOrSuperInspectionSettingsApplier(applier: UnnecessaryQualifierForThisOrSuperInspectionSettingsApplier): SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionSettings>
}
