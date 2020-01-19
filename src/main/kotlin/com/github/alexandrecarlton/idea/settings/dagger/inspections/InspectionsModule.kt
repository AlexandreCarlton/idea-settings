package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.intellij.codeInspection.InspectionProfileEntry
import com.intellij.codeInspection.ex.InspectionToolWrapper
import com.intellij.codeInspection.ex.ScopeToolState
import com.intellij.lang.javascript.linter.eslint.EslintInspection
import com.siyeh.ig.style.UnnecessaryParenthesesInspection
import dagger.Module
import dagger.Provides

@Module
class InspectionsModule {

    @Provides
    internal fun provideInspectionToolWrapper(scopeToolState: ScopeToolState) = scopeToolState.tool

    @Provides
    internal fun provideInspection(inspectionToolWrapper: InspectionToolWrapper<*, *>) = inspectionToolWrapper.tool

    // May want to generate this.
    @Provides
    internal fun provideEslintInspection(inspection: InspectionProfileEntry): EslintInspection =
        inspection as EslintInspection

    @Provides
    internal fun provideUnnecessaryParenthesesInspection(inspection: InspectionProfileEntry): UnnecessaryParenthesesInspection =
        inspection as UnnecessaryParenthesesInspection
}
