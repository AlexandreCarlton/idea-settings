package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.KotlinRedundantConstructsInspectionsSettings
import javax.inject.Inject

class KotlinInspectionsSettingsApplier @Inject
constructor(
    private val kotlinRedundantConstructsInspectionsSettingsApplier: SettingsApplier<KotlinRedundantConstructsInspectionsSettings>
) : SettingsApplier<KotlinInspectionsSettings> {
    override fun apply(settings: KotlinInspectionsSettings) {
        settings.redundantConstructs?.let(kotlinRedundantConstructsInspectionsSettingsApplier::apply)
    }
}
