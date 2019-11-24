package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.ImmutableJavaAutoImportSettings
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
        settingsApplier.apply(ImmutableJavaAutoImportSettings.builder()
            .optimizeImportsOnTheFly(true)
            .build())
        assertThat(codeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue()
    }

    @Test
    fun excludeFromImportAndCompletionApplied() {
        settingsApplier.apply(ImmutableJavaAutoImportSettings.builder()
            .addExcludeFromImportAndCompletion(
                "com.google.inject.Inject",
                "com.sun.istack.internal.Nullable")
            .build())
        assertThat(javaProjectCodeInsightSettings.excludedNames).containsExactlyInAnyOrder(
            "com.google.inject.Inject",
            "com.sun.istack.internal.Nullable")
    }
}
