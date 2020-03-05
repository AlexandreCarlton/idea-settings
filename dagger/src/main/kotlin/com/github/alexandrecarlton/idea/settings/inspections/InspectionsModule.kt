package com.github.alexandrecarlton.idea.settings.inspections

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
@Module
class InspectionsModule {

    @Provides
    internal fun provideInspectionToolWrapper(scopeToolState: ScopeToolState) = scopeToolState.tool

    @Provides
    internal fun provideInspection(inspectionToolWrapper: InspectionToolWrapper<*, *>) = inspectionToolWrapper.tool

    // TODO: may want to generate this.
    @Provides
    internal fun provideEslintInspection(inspection: InspectionProfileEntry): EslintInspection =
        inspection as EslintInspection

    @Provides
    internal fun provideMissingDeprecatedAnnotationInspection(inspection: InspectionProfileEntry): MissingDeprecatedAnnotationInspection =
        inspection as MissingDeprecatedAnnotationInspection

    @Provides
    internal fun provideUnnecessaryParenthesesInspection(inspection: InspectionProfileEntry): UnnecessaryParenthesesInspection =
        inspection as UnnecessaryParenthesesInspection
}
