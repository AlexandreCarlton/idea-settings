package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaWrappingAndBracesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavaWrappingAndBracesSettings>

    @Before
    public override fun setUp() {
        settingsApplier = JavaWrappingAndBracesSettingsApplier(platform.javaCommonCodeStyleSettings, platform.javaCodeStyleSettings)
    }

    @Test
    fun hardWrapAtApplied() {
        settingsApplier.apply(JavaWrappingAndBracesSettings(hardWrapAt = 160))
        assertThat(platform.javaCommonCodeStyleSettings.RIGHT_MARGIN).isEqualTo(160)
    }

    @Test
    fun wrapOnTypingApplied() {
        settingsApplier.apply(JavaWrappingAndBracesSettings(wrapOnTyping = true))
        assertThat(platform.javaCommonCodeStyleSettings.WRAP_ON_TYPING).isEqualTo(1)
    }
}
