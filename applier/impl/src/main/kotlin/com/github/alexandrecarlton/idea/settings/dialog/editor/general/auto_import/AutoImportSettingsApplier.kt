package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class AutoImportSettingsApplier @Inject
constructor(
    private val javaAutoImportSettingsApplier: SettingsApplier<JavaAutoImportSettings>,
    private val kotlinAutoImportSettingsApplier: SettingsApplier<KotlinAutoImportSettings>
) : SettingsApplier<AutoImportSettings> {

    override fun apply(settings: AutoImportSettings) {
        settings.java?.let(javaAutoImportSettingsApplier::apply)
        settings.kotlin?.let(kotlinAutoImportSettingsApplier::apply)
    }
}
