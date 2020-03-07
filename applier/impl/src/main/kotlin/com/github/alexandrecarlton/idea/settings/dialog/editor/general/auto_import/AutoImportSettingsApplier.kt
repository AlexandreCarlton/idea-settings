package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings

import javax.inject.Inject

class AutoImportSettingsApplier @Inject
constructor(private val javaAutoImportSettingsApplier: SettingsApplier<JavaAutoImportSettings>) : SettingsApplier<AutoImportSettings> {

    override fun apply(settings: AutoImportSettings) {
        settings.java?.let(javaAutoImportSettingsApplier::apply)
    }
}
