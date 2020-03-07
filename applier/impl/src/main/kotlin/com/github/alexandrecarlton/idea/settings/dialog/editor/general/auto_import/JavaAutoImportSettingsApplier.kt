package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings

import javax.inject.Inject

class JavaAutoImportSettingsApplier @Inject
constructor(private val codeInsightWorkspaceSettings: CodeInsightWorkspaceSettings,
            private val javaProjectCodeInsightSettings: JavaProjectCodeInsightSettings) : SettingsApplier<JavaAutoImportSettings> {

    override fun apply(settings: JavaAutoImportSettings) {
        settings.optimizeImportsOnTheFly?.let { codeInsightWorkspaceSettings.optimizeImportsOnTheFly = it }

        settings.excludeFromImportAndCompletion?.let { javaProjectCodeInsightSettings.excludedNames = it }
    }
}
