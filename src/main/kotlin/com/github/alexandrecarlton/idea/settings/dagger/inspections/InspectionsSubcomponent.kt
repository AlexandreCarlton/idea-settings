package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.intellij.codeInspection.ex.ScopeToolState
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Unfortunately dagger does not support using generics on subcomponents; so we can't automatically pull in our wanted
 * Options Settings Applier in [BaseInspectionSettingsApplier] via something like:
 *
 * ```
 * interface InspectionsSubcomponent<Options> {
 *     fun settingsApplier(): SettingsApplier<Options>
 *     // ...
 * }
 * ```
 *
 * To circumvent this, we manuallymanually declare each options applier in [InspectionsSubcomponent],
 *
 * Injecting them into a [Map] using multibindings did not take; see https://github.com/google/dagger/issues/1478.
 * @see SettingsApplierModule
 */
@Subcomponent(modules = [
    InspectionsModule::class,
    SettingsApplierModule::class])
interface InspectionsSubcomponent {

    fun unnecessaryParenthesesInspectionOptionsSettingsApplier(): SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun scopeToolState(scopeToolState: ScopeToolState): Builder

        fun build(): InspectionsSubcomponent
    }
}
