package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.imports;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import javax.inject.Inject;

public class JavaImportsSettingsApplier implements SettingsApplier<JavaImportsSettings> {

  private final JavaCodeStyleSettings javaCodeStyleSettings;

  @Inject
  public JavaImportsSettingsApplier(JavaCodeStyleSettings javaCodeStyleSettings) {
    this.javaCodeStyleSettings = javaCodeStyleSettings;
  }

  public void apply(JavaImportsSettings imports) {
    imports.classCountToUseImportWithWildcard().ifPresent(javaCodeStyleSettings::setClassCountToUseImportOnDemand);
    imports.namesCountToUseStaticImportWithWildcard().ifPresent(javaCodeStyleSettings::setNamesCountToUseImportOnDemand);
  }
}
