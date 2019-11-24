package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.ImmutableJavadocAlignmentSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.ImmutableJavadocBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.ImmutableJavadocInvalidTagsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.ImmutableJavadocOtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.ImmutableJavadocSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import org.junit.Before;
import org.junit.Test;

public class JavadocSettingsApplierTest extends IdeaSettingsTestFixture {

  private CommonCodeStyleSettings commonCodeStyleSettings;
  private JavaCodeStyleSettings javaCodeStyleSettings;
  private SettingsApplier<JavadocSettings> settingsApplier;

  @Before
  public void setUp() {
    final CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE);
    javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    settingsApplier = new JavadocSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings);
  }

  @Test
  public void alignParameterDescriptions() {
    assertThat(javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .alignment(ImmutableJavadocAlignmentSettings.builder()
            .alignParameterDescriptions(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_ALIGN_PARAM_COMMENTS).isFalse();
  }

  @Test
  public void alignThrownExceptionDescriptions() {
    assertThat(javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .alignment(ImmutableJavadocAlignmentSettings.builder()
            .alignThrownExceptionDescriptions(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_ALIGN_EXCEPTION_COMMENTS).isFalse();
  }

  @Test
  public void blankLinesAfterDescription() {
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .blankLines(ImmutableJavadocBlankLinesSettings.builder()
            .afterDescription(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_DESCRIPTION).isFalse();
  }

  @Test
  public void blankLinesAfterParameterDescription() {
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .blankLines(ImmutableJavadocBlankLinesSettings.builder()
            .afterParameterDescriptions(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_PARM_COMMENTS).isTrue();
  }

  @Test
  public void blankLinesAfterReturnTag() {
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .blankLines(ImmutableJavadocBlankLinesSettings.builder()
            .afterReturnTag(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_ADD_BLANK_AFTER_RETURN).isTrue();
  }

  @Test
  public void keepInvalidTags() {
    assertThat(javaCodeStyleSettings.JD_KEEP_INVALID_TAGS).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .invalidTags(ImmutableJavadocInvalidTagsSettings.builder()
            .keepInvalidTags(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_KEEP_INVALID_TAGS).isFalse();
  }

  @Test
  public void keepEmptyParamTags() {
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .invalidTags(ImmutableJavadocInvalidTagsSettings.builder()
            .keepEmptyParamTags(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_PARAMETER).isFalse();
  }

  @Test
  public void keepEmptyReturnTags() {
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .invalidTags(ImmutableJavadocInvalidTagsSettings.builder()
            .keepEmptyReturnTags(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_RETURN).isFalse();
  }

  @Test
  public void keepEmptyThrowsTags() {
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .invalidTags(ImmutableJavadocInvalidTagsSettings.builder()
            .keepEmptyThrowsTags(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_EXCEPTION).isFalse();
  }

  @Test
  public void wrapAtRightMargin() {
    assertThat(commonCodeStyleSettings.WRAP_COMMENTS).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .wrapAtRightMargin(true)
            .build())
        .build());
    assertThat(commonCodeStyleSettings.WRAP_COMMENTS).isTrue();
  }

  @Test
  public void enableLeadingAsterisks() {
    assertThat(javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .enableLeadingAsterisks(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_LEADING_ASTERISKS_ARE_ENABLED).isFalse();
  }

  @Test
  public void useThrowsRatherThanException() {
    assertThat(javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .useThrowsRatherThanException(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_USE_THROWS_NOT_EXCEPTION).isFalse();
  }

  @Test
  public void generatePOnEmptyLines() {
    assertThat(javaCodeStyleSettings.JD_P_AT_EMPTY_LINES).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .generatePOnEmptyLines(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_P_AT_EMPTY_LINES).isFalse();
  }

  @Test
  public void keepEmptyLines() {
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_LINES).isTrue();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .keepEmptyLines(false)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_KEEP_EMPTY_LINES).isFalse();
  }

  @Test
  public void doNotWrapOneLineComments() {
    assertThat(javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .doNotWrapOneLineComments(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_DO_NOT_WRAP_ONE_LINE_COMMENTS).isTrue();
  }

  @Test
  public void preserveLineFeeds() {
    assertThat(javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .preserveLineFeeds(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_PRESERVE_LINE_FEEDS).isTrue();
  }

  @Test
  public void parameterDescriptionsOnNewLine() {
    assertThat(javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .parameterDescriptionsOnNewLine(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_PARAM_DESCRIPTION_ON_NEW_LINE).isTrue();
  }

  @Test
  public void indentContinuationLines() {
    assertThat(javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION).isFalse();
    settingsApplier.apply(ImmutableJavadocSettings.builder()
        .other(ImmutableJavadocOtherSettings.builder()
            .indentContinuationLines(true)
            .build())
        .build());
    assertThat(javaCodeStyleSettings.JD_INDENT_ON_CONTINUATION).isTrue();
  }
}
