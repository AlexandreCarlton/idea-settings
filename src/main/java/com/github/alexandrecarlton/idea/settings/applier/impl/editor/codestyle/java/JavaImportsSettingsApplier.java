package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import javax.inject.Inject;

public class JavaImportsSettingsApplier implements SettingsApplier<JavaImportsSettings> {

  private final CodeStyleSettings codeStyleSettings;

  @Inject
  public JavaImportsSettingsApplier(CodeStyleSettings codeStyleSettings) {
    this.codeStyleSettings = codeStyleSettings;
  }

  public void apply(JavaImportsSettings imports) {
    final JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    imports.classCountToUseImportWithWildcard().ifPresent(javaCodeStyleSettings::setClassCountToUseImportOnDemand);
    imports.namesCountToUseStaticImportWithWildcard().ifPresent(javaCodeStyleSettings::setNamesCountToUseImportOnDemand);
  }
}
