package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class KotlinRedundantConstructsInspectionsSettingsApplier @Inject
constructor(
    private val redundantSemicolonInspectionSettingsApplier: SettingsApplier<RedundantSemicolonInspectionSettings>,
    private val unusedImportDirectiveInspectionSettingsApplier: SettingsApplier<UnusedImportDirectiveInspectionSettings>
) : SettingsApplier<KotlinRedundantConstructsInspectionsSettings> {
    override fun apply(settings: KotlinRedundantConstructsInspectionsSettings) {
        settings.redundantSemicolon?.let(redundantSemicolonInspectionSettingsApplier::apply)
        settings.unusedImportDirective?.let(unusedImportDirectiveInspectionSettingsApplier::apply)
    }
}
