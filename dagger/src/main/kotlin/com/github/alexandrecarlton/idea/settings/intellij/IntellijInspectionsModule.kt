package com.github.alexandrecarlton.idea.settings.intellij

import com.intellij.codeInspection.InspectionProfileEntry
import com.intellij.codeInspection.ex.InspectionToolWrapper
import com.intellij.codeInspection.ex.ScopeToolState
import com.intellij.lang.javascript.linter.eslint.EslintInspection
import com.siyeh.ig.javadoc.MissingDeprecatedAnnotationInspection
import com.siyeh.ig.style.UnnecessaryParenthesesInspection
import dagger.Module
import dagger.Provides

/**
 * Provides [InspectionProfileEntry] cast as configurable inspections from a bound [ScopeToolState].
 */
// Stick this in the intellij subpackage in dagger.
@Module
class IntellijInspectionsModule {

    @Provides
    fun provideInspectionToolWrapper(scopeToolState: ScopeToolState) = scopeToolState.tool

    @Provides
    fun provideInspection(inspectionToolWrapper: InspectionToolWrapper<*, *>) = inspectionToolWrapper.tool

    // TODO: may want to generate this.
    @Provides
    fun provideEslintInspection(inspection: InspectionProfileEntry): EslintInspection =
        inspection as EslintInspection

    @Provides
    fun provideMissingDeprecatedAnnotationInspection(inspection: InspectionProfileEntry): MissingDeprecatedAnnotationInspection =
        inspection as MissingDeprecatedAnnotationInspection

    @Provides
    fun provideUnnecessaryParenthesesInspection(inspection: InspectionProfileEntry): UnnecessaryParenthesesInspection =
        inspection as UnnecessaryParenthesesInspection
}
