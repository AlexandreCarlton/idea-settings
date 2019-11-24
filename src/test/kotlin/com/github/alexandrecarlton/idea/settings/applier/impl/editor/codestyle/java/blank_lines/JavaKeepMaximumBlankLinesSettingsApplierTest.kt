package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.ImmutableJavaKeepMaximumBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings
import com.intellij.application.options.CodeStyle
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaKeepMaximumBlankLinesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings
    private lateinit var settingsApplier: SettingsApplier<JavaKeepMaximumBlankLinesSettings>

    @Before
    public override fun setUp() {
        commonCodeStyleSettings = CodeStyle.getSettings(project).getCommonSettings(JavaLanguage.INSTANCE)
        settingsApplier = JavaKeepMaximumBlankLinesSettingsApplier(commonCodeStyleSettings)
    }

    @Test
    fun keepMaximumBlankLinesInDeclarations() {
        settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
            .inDeclarations(10)
            .build())
        assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS).isEqualTo(10)
    }

    @Test
    fun keepMaximumBlankLinesInCode() {
        settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
            .inCode(11)
            .build())
        assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE).isEqualTo(11)
    }

    @Test
    fun keepMaximumBlankLinesBeforeRightBrace() {
        settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
            .beforeRightBrace(12)
            .build())
        assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE).isEqualTo(12)
    }

    @Test
    fun keepMaximumBlankLinesBetweenHeaderAndPackage() {
        settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
            .betweenHeaderAndPackage(13)
            .build())
        assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER).isEqualTo(13)
    }
}
