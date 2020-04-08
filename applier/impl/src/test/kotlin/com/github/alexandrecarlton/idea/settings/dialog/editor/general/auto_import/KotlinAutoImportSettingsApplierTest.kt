package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.kotlin.idea.codeInsight.KotlinCodeInsightWorkspaceSettings
import org.junit.Before
import org.junit.Test

class KotlinAutoImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinAutoImportSettings>
    private lateinit var kotlinCodeInsightWorkspaceSettings: KotlinCodeInsightWorkspaceSettings

    @Before
    public override fun setUp() {
        kotlinCodeInsightWorkspaceSettings = KotlinCodeInsightWorkspaceSettings.getInstance(project)
        settingsApplier = KotlinAutoImportSettingsApplier(kotlinCodeInsightWorkspaceSettings)
    }

    @Test
    fun optimizeImportsOnTheFlyApplied() {
        assertThat(kotlinCodeInsightWorkspaceSettings.optimizeImportsOnTheFly).isFalse()
        settingsApplier.apply(KotlinAutoImportSettings(optimizeImportsOnTheFly = true))
        assertThat(kotlinCodeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue()
    }
}
