package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinBlankLinesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinBlankLinesSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinBlankLinesSettingsApplier(platform.kotlinCommonCodeStyleSettings, platform.kotlinCodeStyleSettings)
    }

    @Test
    fun keepBlankLinesBeforeRightBrace() {
        settingsApplier.apply(KotlinBlankLinesSettings(
            keepMaximumBlankLines = KotlinKeepMaximumBlankLinesSettings(
                beforeRightBrace = 5)))
        assertThat(platform.kotlinCommonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE).isEqualTo(5)
    }

    @Test
    fun keepBlankLinesInCode() {
        settingsApplier.apply(KotlinBlankLinesSettings(
            keepMaximumBlankLines = KotlinKeepMaximumBlankLinesSettings(
                inCode = 6)))
        assertThat(platform.kotlinCommonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE).isEqualTo(6)
    }

    @Test
    fun keepBlankLinesInDeclarations() {
        settingsApplier.apply(KotlinBlankLinesSettings(
            keepMaximumBlankLines = KotlinKeepMaximumBlankLinesSettings(
                inDeclarations = 7)))
        assertThat(platform.kotlinCommonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS).isEqualTo(7)
    }

    @Test
    fun blankLinesAfterClassHeader() {
        settingsApplier.apply(KotlinBlankLinesSettings(
            minimumBlankLines = KotlinMinimumBlankLinesSettings(
                afterClassHeader = 8)))
        assertThat(platform.kotlinCommonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER).isEqualTo(8)
    }

    @Test
    fun blankLinesAroundWhenBranchesWithBraces() {
        settingsApplier.apply(KotlinBlankLinesSettings(
            minimumBlankLines = KotlinMinimumBlankLinesSettings(
                aroundWhenBranchesWithBraces = 9)))
        assertThat(platform.kotlinCodeStyleSettings.BLANK_LINES_AROUND_BLOCK_WHEN_BRANCHES).isEqualTo(9)
    }
}
