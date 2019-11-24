package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.ImmutableJavaMinimumBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import org.junit.Before;
import org.junit.Test;

public class JavaMinimumBlankLinesSettingsApplierTest extends IdeaSettingsTestFixture {

  private CommonCodeStyleSettings commonCodeStyleSettings;
  private JavaCodeStyleSettings javaCodeStyleSettings;
  private SettingsApplier<JavaMinimumBlankLinesSettings> settingsApplier;

  @Before
  public void setUp() {
    CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE);
    javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    settingsApplier = new JavaMinimumBlankLinesSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings);
  }

  @Test
  public void minimumBlankLinesBeforePackageStatement() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .beforePackageStatement(10)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_PACKAGE).isEqualTo(10);
  }

  @Test
  public void minimumBlankLinesAfterPackageStatement() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .afterPackageStatement(11)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_PACKAGE).isEqualTo(11);
  }

  @Test
  public void minimumBlankLinesBeforeImports() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .beforeImports(12)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_IMPORTS).isEqualTo(12);
  }

  @Test
  public void minimumBlankLinesAfterImports() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .afterImports(13)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_IMPORTS).isEqualTo(13);
  }

  @Test
  public void minimumBlankLinesAroundClass() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundClass(14)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_CLASS).isEqualTo(14);
  }

  @Test
  public void minimumBlankLinesAfterClassHeader() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .afterClassHeader(15)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER).isEqualTo(15);
  }

  @Test
  public void minimumBlankLinesBeforeClassEnd() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .beforeClassEnd(16)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_CLASS_END).isEqualTo(16);
  }

  @Test
  public void minimumBlankLinesAfterAnonymousClassHeader() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .afterAnonymousClassHeader(17)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER).isEqualTo(17);
  }

  @Test
  public void minimumBlankLinesAroundFieldInInterface() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundFieldInInterface(18)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD_IN_INTERFACE).isEqualTo(18);
  }

  @Test
  public void minimumBlankLinesAroundField() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundField(19)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD).isEqualTo(19);
  }

  @Test
  public void minimumBlankLinesAroundMethodInInterface() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundMethodInInterface(20)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD_IN_INTERFACE).isEqualTo(20);
  }

  @Test
  public void minimumBlankLinesAroundMethod() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundMethod(21)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD).isEqualTo(21);
  }

  @Test
  public void minimumBlankLinesBeforeMethodBody() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .beforeMethodBody(22)
        .build());
    assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_METHOD_BODY).isEqualTo(22);
  }

  @Test
  public void minimumBlankLinesAroundInitializer() {
    settingsApplier.apply(ImmutableJavaMinimumBlankLinesSettings.builder()
        .aroundInitializer(23)
        .build());
    assertThat(javaCodeStyleSettings.BLANK_LINES_AROUND_INITIALIZER).isEqualTo(23);
  }

}
