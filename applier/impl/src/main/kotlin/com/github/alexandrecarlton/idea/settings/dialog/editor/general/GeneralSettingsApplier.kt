package com.github.alexandrecarlton.idea.settings.dialog.editor.general

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.AutoImportSettings
import javax.inject.Inject

class GeneralSettingsApplier @Inject
constructor(private val autoImportSettingsSettingsApplier: SettingsApplier<AutoImportSettings>) : SettingsApplier<GeneralSettings> {

    override fun apply(settings: GeneralSettings) {
        settings.autoImport?.let(autoImportSettingsSettingsApplier::apply)
    }
}
