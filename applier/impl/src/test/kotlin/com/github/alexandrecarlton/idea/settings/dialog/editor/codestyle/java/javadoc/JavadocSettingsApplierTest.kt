package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavadocSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings
    private lateinit var javaCodeStyleSettings: JavaCodeStyleSettings
    private lateinit var settingsApplier: SettingsApplier<JavadocSettings>

    @Before
    public override fun setUp() {
        val codeStyleSettings = CodeStyle.getSettings(project)
        commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)
        javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings::class.java)
        settingsApplier = JavadocSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings)
    }

    @Test
    fun alignParameterDescriptions() {
        assertThat(javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS).isTrue()
        settingsApplier.apply(JavadocSettings(alignment = JavadocAlignmentSettings(alignParameterDescriptions = false)))
        assertThat(javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS).isFalse()
    }

    @Test
    fun alignThrownExceptionDescriptions() {
        assertThat(javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS).isTrue()
        settingsApplier.apply(JavadocSettings(alignment = JavadocAlignmentSettings(alignThrownExceptionDescriptions = false)))
        assertThat(javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS).isFalse()
    }

    @Test
    fun blankLinesAfterDescription() {
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION).isTrue()
        settingsApplier.apply(JavadocSettings(blankLines = JavadocBlankLinesSettings(afterDescription = false)))
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION).isFalse()
    }

    @Test
    fun blankLinesAfterParameterDescription() {
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS).isFalse()
        settingsApplier.apply(JavadocSettings(blankLines = JavadocBlankLinesSettings(afterParameterDescriptions = true)))
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS).isTrue()
    }

    @Test
    fun blankLinesAfterReturnTag() {
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN).isFalse()
        settingsApplier.apply(JavadocSettings(blankLines = JavadocBlankLinesSettings(afterReturnTag = true)))
        assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN).isTrue()
    }

    @Test
    fun keepInvalidTags() {
        assertThat(javaCodeStyleSettings.JD_KEEP_INVALID_TAGS).isTrue()
        settingsApplier.apply(JavadocSettings(invalidTags = JavadocInvalidTagsSettings(keepInvalidTags = false)))
        assertThat(javaCodeStyleSettings.JD_KEEP_INVALID_TAGS).isFalse()
    }

    @Test
    fun keepEmptyParamTags() {
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER).isTrue()
        settingsApplier.apply(JavadocSettings(invalidTags = JavadocInvalidTagsSettings(keepEmptyParamTags = false)))
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER).isFalse()
    }

    @Test
    fun keepEmptyReturnTags() {
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN).isTrue()
        settingsApplier.apply(JavadocSettings(invalidTags = JavadocInvalidTagsSettings(keepEmptyReturnTags = false)))
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN).isFalse()
    }

    @Test
    fun keepEmptyThrowsTags() {
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION).isTrue()
        settingsApplier.apply(JavadocSettings(invalidTags = JavadocInvalidTagsSettings(keepEmptyThrowsTags = false)))
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION).isFalse()
    }

    @Test
    fun wrapAtRightMargin() {
        assertThat(commonCodeStyleSettings.WRAP_COMMENTS).isFalse()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(wrapAtRightMargin = true)))
        assertThat(commonCodeStyleSettings.WRAP_COMMENTS).isTrue()
    }

    @Test
    fun enableLeadingAsterisks() {
        assertThat(javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED).isTrue()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(enableLeadingAsterisks = false)))
        assertThat(javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED).isFalse()
    }

    @Test
    fun useThrowsRatherThanException() {
        assertThat(javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION).isTrue()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(useThrowsRatherThanException = false)))
        assertThat(javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION).isFalse()
    }

    @Test
    fun generatePOnEmptyLines() {
        assertThat(javaCodeStyleSettings.JD_P_AT_EMPTY_LINES).isTrue()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(generatePOnEmptyLines = false)))
        assertThat(javaCodeStyleSettings.JD_P_AT_EMPTY_LINES).isFalse()
    }

    @Test
    fun keepEmptyLines() {
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_LINES).isTrue()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(keepEmptyLines = false)))
        assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_LINES).isFalse()
    }

    @Test
    fun doNotWrapOneLineComments() {
        assertThat(javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS).isFalse()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(doNotWrapOneLineComments = true)))
        assertThat(javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS).isTrue()
    }

    @Test
    fun preserveLineFeeds() {
        assertThat(javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS).isFalse()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(preserveLineFeeds = true)))
        assertThat(javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS).isTrue()
    }

    @Test
    fun parameterDescriptionsOnNewLine() {
        assertThat(javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE).isFalse()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(parameterDescriptionsOnNewLine = true)))
        assertThat(javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE).isTrue()
    }

    @Test
    fun indentContinuationLines() {
        assertThat(javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION).isFalse()
        settingsApplier.apply(JavadocSettings(other = JavadocOtherSettings(indentContinuationLines = true)))
        assertThat(javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION).isTrue()
    }
}
