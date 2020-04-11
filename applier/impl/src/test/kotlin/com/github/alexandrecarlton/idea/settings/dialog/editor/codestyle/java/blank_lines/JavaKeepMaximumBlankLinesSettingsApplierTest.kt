package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaKeepMaximumBlankLinesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavaKeepMaximumBlankLinesSettings>

    @Before
    public override fun setUp() {
        settingsApplier = JavaKeepMaximumBlankLinesSettingsApplier(platform.javaCommonCodeStyleSettings)
    }

    @Test
    fun keepMaximumBlankLinesInDeclarations() {
        settingsApplier.apply(JavaKeepMaximumBlankLinesSettings(inDeclarations = 10))
        assertThat(platform.javaCommonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS).isEqualTo(10)
    }

    @Test
    fun keepMaximumBlankLinesInCode() {
        settingsApplier.apply(JavaKeepMaximumBlankLinesSettings(inCode = 11))
        assertThat(platform.javaCommonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE).isEqualTo(11)
    }

    @Test
    fun keepMaximumBlankLinesBeforeRightBrace() {
        settingsApplier.apply(JavaKeepMaximumBlankLinesSettings(beforeRightBrace = 12))
        assertThat(platform.javaCommonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE).isEqualTo(12)
    }

    @Test
    fun keepMaximumBlankLinesBetweenHeaderAndPackage() {
        settingsApplier.apply(JavaKeepMaximumBlankLinesSettings(betweenHeaderAndPackage = 13))
        assertThat(platform.javaCommonCodeStyleSettings.KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER).isEqualTo(13)
    }
}
