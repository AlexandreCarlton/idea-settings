package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.ImmutableJavaKeepMaximumBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import org.junit.Before;
import org.junit.Test;

public class JavaKeepMaximumBlankLinesSettingsApplierTest extends IdeaSettingsTestFixture {

  private CommonCodeStyleSettings commonCodeStyleSettings;
  private SettingsApplier<JavaKeepMaximumBlankLinesSettings> settingsApplier;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    commonCodeStyleSettings = CodeStyle.getSettings(project).getCommonSettings(JavaLanguage.INSTANCE);
    settingsApplier = new JavaKeepMaximumBlankLinesSettingsApplier(commonCodeStyleSettings);
  }

  @Test
  public void keepMaximumBlankLinesInDeclarations() {
    settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
        .inDeclarations(10)
        .build());
    assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS).isEqualTo(10);
  }

  @Test
  public void keepMaximumBlankLinesInCode() {
    settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
        .inCode(11)
        .build());
    assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE).isEqualTo(11);
  }

  @Test
  public void keepMaximumBlankLinesBeforeRightBrace() {
    settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
        .beforeRightBrace(12)
        .build());
    assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE).isEqualTo(12);
  }

  @Test
  public void keepMaximumBlankLinesBetweenHeaderAndPackage() {
    settingsApplier.apply(ImmutableJavaKeepMaximumBlankLinesSettings.builder()
        .betweenHeaderAndPackage(13)
        .build());
    assertThat(commonCodeStyleSettings.KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER).isEqualTo(13);
  }
}
