package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.subcomponent

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.JavaCodeStyleIssuesInspectionsOptionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.options.JavadocInspectionsOptionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.options.JavaProbableBugsInspectionsOptionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.options.JavascriptCodeQualityToolsInspectionsOptionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.KotlinRedundantConstructsInspectionsOptionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.options.InspectionOptionsModule
import com.github.alexandrecarlton.idea.settings.intellij.IntellijInspectionsModule
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
 * @see InspectionOptionsModule
 */
@Subcomponent(modules = [
    IntellijInspectionsModule::class,
    InspectionOptionsModule::class,
    JavaCodeStyleIssuesInspectionsOptionsModule::class,
    JavadocInspectionsOptionsModule::class,
    JavaProbableBugsInspectionsOptionsModule::class,
    JavascriptCodeQualityToolsInspectionsOptionsModule::class,
    KotlinRedundantConstructsInspectionsOptionsModule::class
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
