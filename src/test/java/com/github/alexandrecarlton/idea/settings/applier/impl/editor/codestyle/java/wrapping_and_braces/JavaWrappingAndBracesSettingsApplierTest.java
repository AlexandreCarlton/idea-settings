package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.ImmutableJavaWrappingAndBracesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import org.junit.Before;
import org.junit.Test;

public class JavaWrappingAndBracesSettingsApplierTest extends IdeaSettingsTestFixture {

  private CommonCodeStyleSettings commonCodeStyleSettings;
  private JavaCodeStyleSettings javaCodeStyleSettings;
  private SettingsApplier<JavaWrappingAndBracesSettings> settingsApplier;

  @Before
  public void setUp() {
    final CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE);
    javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    settingsApplier = new JavaWrappingAndBracesSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings);
  }

  @Test
  public void hardWrapAtApplied() {
    settingsApplier.apply(ImmutableJavaWrappingAndBracesSettings.builder()
        .hardWrapAt(160)
        .build());
    assertThat(commonCodeStyleSettings.RIGHT_MARGIN).isEqualTo(160);
  }

  @Test
  public void wrapOnTypingApplied() {
    settingsApplier.apply(ImmutableJavaWrappingAndBracesSettings.builder()
        .wrapOnTyping(true)
        .build());
    assertThat(commonCodeStyleSettings.WRAP_ON_TYPING).isEqualTo(1);
  }

}
