package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.imports;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.ImmutableJavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JavaImportSettingsApplierTest extends IdeaSettingsTestFixture {

  private JavaCodeStyleSettings javaCodeStyleSettings;
  private SettingsApplier<JavaImportsSettings> applier;

  @Before
  public void setUp() {
    javaCodeStyleSettings = CodeStyle.getSettings(project).getCustomSettings(JavaCodeStyleSettings.class);
    applier = new JavaImportsSettingsApplier(javaCodeStyleSettings);
  }

  @After
  public void tearDown() {
    // The normal tear-down tries to verify that Code Insight settings haven't changed,
    // so we restore this just before finishing up.
    CodeStyle.getSettings(project).copyFrom(CodeStyleSettings.getDefaults());
  }

  @Test
  public void classCountToUseWithImportSettingsAreApplied() {
    applier.apply(ImmutableJavaImportsSettings.builder()
        .classCountToUseImportWithWildcard(555)
        .build());
    assertThat(javaCodeStyleSettings.CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(555);
  }

  @Test
  public void namesCountToUseWithStaticImportSettingsAreApplied() {
    applier.apply(ImmutableJavaImportsSettings.builder()
        .namesCountToUseStaticImportWithWildcard(777)
        .build());
    assertThat(javaCodeStyleSettings.NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(777);
  }

}
