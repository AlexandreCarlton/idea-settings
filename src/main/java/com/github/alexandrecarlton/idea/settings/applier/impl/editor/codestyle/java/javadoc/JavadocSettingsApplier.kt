package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings
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
        settings.alignment()
            .flatMap { it.alignParameterDescriptions() }
            .ifPresent { javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS = it }
        settings.alignment()
            .flatMap { it.alignThrownExceptionDescriptions() }
            .ifPresent { javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS = it }

        settings.blankLines()
            .flatMap { it.afterDescription() }
            .ifPresent { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION = it }
        settings.blankLines()
            .flatMap { it.afterParameterDescriptions() }
            .ifPresent { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS = it }
        settings.blankLines()
            .flatMap { it.afterReturnTag() }
            .ifPresent { javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN = it }

        settings.invalidTags()
            .flatMap { it.keepInvalidTags() }
            .ifPresent { javaCodeStyleSettings.JD_KEEP_INVALID_TAGS = it }
        settings.invalidTags()
            .flatMap { it.keepEmptyParamTags() }
            .ifPresent { javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER = it }
        settings.invalidTags()
            .flatMap { it.keepEmptyReturnTags() }
            .ifPresent { javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN = it }
        settings.invalidTags()
            .flatMap { it.keepEmptyThrowsTags() }
            .ifPresent { javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION = it }

        settings.other()
            .flatMap { it.wrapAtRightMargin() }
            .ifPresent { commonCodeStyleSettings.WRAP_COMMENTS = it }
        settings.other()
            .flatMap { it.enableLeadingAsterisks() }
            .ifPresent { javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED = it }
        settings.other()
            .flatMap { it.useThrowsRatherThanException() }
            .ifPresent { javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION = it }
        settings.other()
            .flatMap { it.generatePOnEmptyLines() }
            .ifPresent { javaCodeStyleSettings.JD_P_AT_EMPTY_LINES = it }
        settings.other()
            .flatMap { it.keepEmptyLines() }
            .ifPresent { javaCodeStyleSettings.JD_KEEP_EMPTY_LINES = it }
        settings.other()
            .flatMap { it.doNotWrapOneLineComments() }
            .ifPresent { javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS = it }
        settings.other()
            .flatMap { it.preserveLineFeeds() }
            .ifPresent { javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS = it }
        settings.other()
            .flatMap { it.parameterDescriptionsOnNewLine() }
            .ifPresent { javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE = it }
        settings.other()
            .flatMap { it.indentContinuationLines() }
            .ifPresent { javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION = it }
    }
}
