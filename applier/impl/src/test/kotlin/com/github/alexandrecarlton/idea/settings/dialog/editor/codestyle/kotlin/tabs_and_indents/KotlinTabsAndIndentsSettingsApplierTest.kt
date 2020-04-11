package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinTabsAndIndentsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinTabsAndIndentsSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinTabsAndIndentsSettingsApplier(platform.kotlinCommonCodeStyleSettings)
    }

    @Test
    fun continuationIndent() {
        settingsApplier.apply(KotlinTabsAndIndentsSettings(
            continuationIndent = 12))
        assertThat(platform.kotlinCommonCodeStyleSettings.indentOptions?.CONTINUATION_INDENT_SIZE).isEqualTo(12)
    }
}
