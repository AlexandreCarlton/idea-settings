package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinAutoImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinAutoImportSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinAutoImportSettingsApplier(platform.kotlinCodeInsightWorkspaceSettings)
    }

    @Test
    fun optimizeImportsOnTheFlyApplied() {
        assertThat(platform.kotlinCodeInsightWorkspaceSettings.optimizeImportsOnTheFly).isFalse()
        settingsApplier.apply(KotlinAutoImportSettings(optimizeImportsOnTheFly = true))
        assertThat(platform.kotlinCodeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue()
    }
}
