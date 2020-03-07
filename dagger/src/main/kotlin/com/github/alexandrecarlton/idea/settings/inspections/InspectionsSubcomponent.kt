package com.github.alexandrecarlton.idea.settings.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.codeInspection.ex.ScopeToolState
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Unfortunately dagger does not support using generics on subcomponents; so we can't automatically pull in our wanted
 * Options Settings Applier in [com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier]
 * via something like:
 *
 * ```
 * interface InspectionsSubcomponent<Options> {
 *     fun settingsApplier(): SettingsApplier<Options>
 *     // ...
 * }
 * ```
 *
 * To circumvent this, we manually declare each options applier in [InspectionsSubcomponent],
 *
 * Injecting them into a [Map] using multibindings did not take; see https://github.com/google/dagger/issues/1478.
 * @see InspectionOptionsSettingsApplierModule
 */
@Subcomponent(modules = [
    InspectionsModule::class,
    InspectionOptionsSettingsApplierModule::class,
    NoOpInspectionOptionsSettingsApplierModule::class
])
interface InspectionsSubcomponent {

    fun settingsApplier(): SettingsApplier<Any>

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun scopeToolState(scopeToolState: ScopeToolState): Builder

        fun build(): InspectionsSubcomponent
    }
}
