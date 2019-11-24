package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.ImmutableJavaWrappingAndBracesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings
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
        settingsApplier.apply(ImmutableJavaWrappingAndBracesSettings.builder()
            .hardWrapAt(160)
            .build())
        assertThat(commonCodeStyleSettings.RIGHT_MARGIN).isEqualTo(160)
    }

    @Test
    fun wrapOnTypingApplied() {
        settingsApplier.apply(ImmutableJavaWrappingAndBracesSettings.builder()
            .wrapOnTyping(true)
            .build())
        assertThat(commonCodeStyleSettings.WRAP_ON_TYPING).isEqualTo(1)
    }
}
