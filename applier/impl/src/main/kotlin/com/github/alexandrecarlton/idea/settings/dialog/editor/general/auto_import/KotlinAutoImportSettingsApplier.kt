package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import org.jetbrains.kotlin.idea.codeInsight.KotlinCodeInsightWorkspaceSettings
import javax.inject.Inject

class KotlinAutoImportSettingsApplier @Inject
constructor(
    private val kotlinCodeInsightWorkspaceSettings: KotlinCodeInsightWorkspaceSettings
) : SettingsApplier<KotlinAutoImportSettings> {

    override fun apply(settings: KotlinAutoImportSettings) {
        settings.optimizeImportsOnTheFly?.let { kotlinCodeInsightWorkspaceSettings.optimizeImportsOnTheFly = it }
    }
}
