package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaAutoImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavaAutoImportSettings>
    private lateinit var codeInsightWorkspaceSettings: CodeInsightWorkspaceSettings
    private lateinit var javaProjectCodeInsightSettings: JavaProjectCodeInsightSettings

    @Before
    public override fun setUp() {
        codeInsightWorkspaceSettings = CodeInsightWorkspaceSettings.getInstance(project)
        javaProjectCodeInsightSettings = JavaProjectCodeInsightSettings.getSettings(project)
        settingsApplier = JavaAutoImportSettingsApplier(codeInsightWorkspaceSettings, javaProjectCodeInsightSettings)
    }

    @Test
    fun optimizeImportsOnTheFlyApplied() {
        settingsApplier.apply(JavaAutoImportSettings(optimizeImportsOnTheFly = true))
        assertThat(codeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue()
    }

    @Test
    fun excludeFromImportAndCompletionApplied() {
        settingsApplier.apply(JavaAutoImportSettings(
            excludeFromImportAndCompletion = listOf(
                "com.google.inject.Inject",
                "com.sun.istack.internal.Nullable")))
        assertThat(javaProjectCodeInsightSettings.excludedNames).containsExactlyInAnyOrder(
            "com.google.inject.Inject",
            "com.sun.istack.internal.Nullable")
    }
}
