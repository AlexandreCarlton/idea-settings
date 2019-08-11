package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.ImmutableJavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;

import org.junit.Test;

public class JavaImportSettingsApplierTest extends IdeaSettingsTestFixture {

  private CodeStyleSettings codeStyleSettings;
  private SettingsApplier<JavaImportsSettings> applier;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    codeStyleSettings = CodeStyle.getSettings(project);
    applier = new JavaImportsSettingsApplier(codeStyleSettings, project);
  }

  @Override
  public void tearDown() throws Exception {
    // The normal tear-down tries to verify that Code Insight settings haven't changed,
    // so we restore this just before finishing up.
    CodeStyle.getSettings(project).copyFrom(CodeStyleSettings.getDefaults());
    super.tearDown();
  }

  @Test
  public void classCountToUseWithImportSettingsAreApplied() {
    applier.apply(ImmutableJavaImportsSettings.builder()
        .classCountToUseImportWithWildcard(555)
        .build());
    final JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    assertThat(javaCodeStyleSettings.CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(555);
  }

  @Test
  public void namesCountToUseWithStaticImportSettingsAreApplied() {
    applier.apply(ImmutableJavaImportsSettings.builder()
        .namesCountToUseStaticImportWithWildcard(777)
        .build());
    final JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    assertThat(javaCodeStyleSettings.NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(777);
  }

}
