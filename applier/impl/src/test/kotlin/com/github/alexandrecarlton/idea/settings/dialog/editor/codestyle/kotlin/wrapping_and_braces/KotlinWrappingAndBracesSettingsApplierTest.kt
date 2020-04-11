package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinWrappingAndBracesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinWrappingAndBracesSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinWrappingAndBracesSettingsApplier(platform.kotlinCommonCodeStyleSettings)
    }

    @Test
    fun functionDeclarationParametersAlignWhenMultiline() {
        assertThat(platform.kotlinCommonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS).isTrue()
        settingsApplier.apply(KotlinWrappingAndBracesSettings(
            functionDeclarationParameters = KotlinFunctionDeclarationParametersSettings(
                alignWhenMultiline = false)))
        assertThat(platform.kotlinCommonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS).isFalse()
    }

}
