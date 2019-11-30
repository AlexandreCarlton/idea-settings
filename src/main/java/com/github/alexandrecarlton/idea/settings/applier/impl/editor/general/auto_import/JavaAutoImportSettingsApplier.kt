package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings

import javax.inject.Inject

class JavaAutoImportSettingsApplier @Inject
constructor(private val codeInsightWorkspaceSettings: CodeInsightWorkspaceSettings,
            private val javaProjectCodeInsightSettings: JavaProjectCodeInsightSettings) : SettingsApplier<JavaAutoImportSettings> {

    override fun apply(settings: JavaAutoImportSettings) {
        settings.optimizeImportsOnTheFly().ifPresent { codeInsightWorkspaceSettings.optimizeImportsOnTheFly = it }

        javaProjectCodeInsightSettings.excludedNames = settings.excludeFromImportAndCompletion()
    }
}
