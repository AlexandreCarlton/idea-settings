package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings

import javax.inject.Inject

class GeneralSettingsApplier @Inject
constructor(private val autoImportSettingsSettingsApplier: SettingsApplier<AutoImportSettings>) : SettingsApplier<GeneralSettings> {

    override fun apply(settings: GeneralSettings) {
        settings.autoImport?.let(autoImportSettingsSettingsApplier::apply)
    }
}
