package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocAlignmentSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocInvalidTagsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocOtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import javax.inject.Inject;
import javax.inject.Named;

public class JavadocSettingsApplier implements SettingsApplier<JavadocSettings> {

  private final CommonCodeStyleSettings commonCodeStyleSettings;
  private final JavaCodeStyleSettings javaCodeStyleSettings;

  @Inject
  public JavadocSettingsApplier(@Named("java") CommonCodeStyleSettings commonCodeStyleSettings, JavaCodeStyleSettings javaCodeStyleSettings) {
    this.commonCodeStyleSettings = commonCodeStyleSettings;
    this.javaCodeStyleSettings = javaCodeStyleSettings;
  }

  @Override
  public void apply(JavadocSettings settings) {
    settings.alignment()
        .flatMap(JavadocAlignmentSettings::alignParameterDescriptions)
        .ifPresent(align -> javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS = align);
    settings.alignment()
        .flatMap(JavadocAlignmentSettings::alignThrownExceptionDescriptions)
        .ifPresent(align -> javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS = align);

    settings.blankLines()
        .flatMap(JavadocBlankLinesSettings::afterDescription)
        .ifPresent(addBlank -> javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION = addBlank);
    settings.blankLines()
        .flatMap(JavadocBlankLinesSettings::afterParameterDescriptions)
        .ifPresent(addBlank -> javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS = addBlank);
    settings.blankLines()
        .flatMap(JavadocBlankLinesSettings::afterReturnTag)
        .ifPresent(addBlank -> javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN = addBlank);

    settings.invalidTags()
        .flatMap(JavadocInvalidTagsSettings::keepInvalidTags)
        .ifPresent(keep -> javaCodeStyleSettings.JD_KEEP_INVALID_TAGS = keep);
    settings.invalidTags()
        .flatMap(JavadocInvalidTagsSettings::keepEmptyParamTags)
        .ifPresent(keep -> javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER = keep);
    settings.invalidTags()
        .flatMap(JavadocInvalidTagsSettings::keepEmptyReturnTags)
        .ifPresent(keep -> javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN = keep);
    settings.invalidTags()
        .flatMap(JavadocInvalidTagsSettings::keepEmptyThrowsTags)
        .ifPresent(keep -> javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION = keep);

    settings.other()
        .flatMap(JavadocOtherSettings::wrapAtRightMargin)
        .ifPresent(wrap -> commonCodeStyleSettings.WRAP_COMMENTS = wrap);
    settings.other()
        .flatMap(JavadocOtherSettings::enableLeadingAsterisks)
        .ifPresent(enabled -> javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED = enabled);
    settings.other()
        .flatMap(JavadocOtherSettings::useThrowsRatherThanException)
        .ifPresent(useThrows -> javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION = useThrows);
    settings.other()
        .flatMap(JavadocOtherSettings::generatePOnEmptyLines)
        .ifPresent(generate -> javaCodeStyleSettings.JD_P_AT_EMPTY_LINES = generate);
    settings.other()
        .flatMap(JavadocOtherSettings::keepEmptyLines)
        .ifPresent(keep -> javaCodeStyleSettings.JD_KEEP_EMPTY_LINES = keep);
    settings.other()
        .flatMap(JavadocOtherSettings::doNotWrapOneLineComments)
        .ifPresent(doNotWrap -> javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS = doNotWrap);
    settings.other()
        .flatMap(JavadocOtherSettings::preserveLineFeeds)
        .ifPresent(preserve -> javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS = preserve);
    settings.other()
        .flatMap(JavadocOtherSettings::parameterDescriptionsOnNewLine)
        .ifPresent(onNewLine -> javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE = onNewLine);
    settings.other()
        .flatMap(JavadocOtherSettings::indentContinuationLines)
        .ifPresent(indent -> javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION = indent);

  }

}
