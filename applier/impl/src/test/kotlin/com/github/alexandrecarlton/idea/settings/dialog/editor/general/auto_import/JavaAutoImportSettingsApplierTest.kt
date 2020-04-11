package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaAutoImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavaAutoImportSettings>

    @Before
    public override fun setUp() {
        settingsApplier = JavaAutoImportSettingsApplier(platform.codeInsightWorkspaceSettings, platform.javaProjectCodeInsightSettings)
    }

    @Test
    fun optimizeImportsOnTheFlyApplied() {
        settingsApplier.apply(JavaAutoImportSettings(optimizeImportsOnTheFly = true))
        assertThat(platform.codeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue()
    }

    @Test
    fun excludeFromImportAndCompletionApplied() {
        settingsApplier.apply(JavaAutoImportSettings(
            excludeFromImportAndCompletion = listOf(
                "com.google.inject.Inject",
                "com.sun.istack.internal.Nullable")))
        assertThat(platform.javaProjectCodeInsightSettings.excludedNames).containsExactlyInAnyOrder(
            "com.google.inject.Inject",
            "com.sun.istack.internal.Nullable")
    }
}
