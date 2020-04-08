package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.junit.Before
import org.junit.Test

class KotlinWrappingAndBracesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinWrappingAndBracesSettings>
    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings

    @Before
    public override fun setUp() {
        commonCodeStyleSettings = CodeStyle.getSettings(project).getCommonSettings(KotlinLanguage.INSTANCE)
        settingsApplier = KotlinWrappingAndBracesSettingsApplier(commonCodeStyleSettings)
    }

    @Test
    fun functionDeclarationParametersAlignWhenMultiline() {
        assertThat(commonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS).isTrue()
        settingsApplier.apply(KotlinWrappingAndBracesSettings(
            functionDeclarationParameters = KotlinFunctionDeclarationParametersSettings(
                alignWhenMultiline = false)))
        assertThat(commonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS).isFalse()
    }

}
