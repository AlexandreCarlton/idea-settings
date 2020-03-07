package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaWrappingAndBracesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings
    private lateinit var javaCodeStyleSettings: JavaCodeStyleSettings
    private lateinit var settingsApplier: SettingsApplier<JavaWrappingAndBracesSettings>

    @Before
    public override fun setUp() {
        val codeStyleSettings = CodeStyle.getSettings(project)
        commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)
        javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings::class.java)
        settingsApplier = JavaWrappingAndBracesSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings)
    }

    @Test
    fun hardWrapAtApplied() {
        settingsApplier.apply(JavaWrappingAndBracesSettings(hardWrapAt = 160))
        assertThat(commonCodeStyleSettings.RIGHT_MARGIN).isEqualTo(160)
    }

    @Test
    fun wrapOnTypingApplied() {
        settingsApplier.apply(JavaWrappingAndBracesSettings(wrapOnTyping = true))
        assertThat(commonCodeStyleSettings.WRAP_ON_TYPING).isEqualTo(1)
    }
}
