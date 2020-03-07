package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class JavadocSettingsApplier @Inject
constructor(
    @param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings,
    private val javaCodeStyleSettings: JavaCodeStyleSettings
) : SettingsApplier<JavadocSettings> {

    override fun apply(settings: JavadocSettings) {
        settings.alignment?.alignParameterDescriptions?.let { javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS = it }
        settings.alignment?.alignThrownExceptionDescriptions?.let { javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS = it }

        settings.blankLines?.afterDescription?.let { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION = it }
        settings.blankLines?.afterParameterDescriptions?.let { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS = it }
        settings.blankLines?.afterReturnTag?.let { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN = it }

        settings.invalidTags?.keepInvalidTags?.let { javaCodeStyleSettings.JD_KEEP_INVALID_TAGS = it }
        settings.invalidTags?.keepEmptyParamTags?.let { javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER = it }
        settings.invalidTags?.keepEmptyReturnTags?.let  { javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN = it }
        settings.invalidTags?.keepEmptyThrowsTags?.let { javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION = it }

        settings.other?.wrapAtRightMargin?.let { commonCodeStyleSettings.WRAP_COMMENTS = it }
        settings.other?.enableLeadingAsterisks?.let { javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED = it }
        settings.other?.useThrowsRatherThanException?.let { javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION = it }
        settings.other?.generatePOnEmptyLines?.let { javaCodeStyleSettings.JD_P_AT_EMPTY_LINES = it }
        settings.other?.keepEmptyLines?.let { javaCodeStyleSettings.JD_KEEP_EMPTY_LINES = it }
        settings.other?.doNotWrapOneLineComments?.let { javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS = it }
        settings.other?.preserveLineFeeds?.let { javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS = it }
        settings.other?.parameterDescriptionsOnNewLine?.let { javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE = it }
        settings.other?.indentContinuationLines?.let { javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION = it }
    }
}
