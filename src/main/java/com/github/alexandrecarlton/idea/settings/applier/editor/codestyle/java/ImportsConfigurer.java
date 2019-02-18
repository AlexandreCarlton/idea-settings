package com.github.alexandrecarlton.idea.settings.applier;

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.ImportsSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.openapi.project.Project;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;

public class ImportsConfigurer {

  public void configure(Project project, ImportsSettings imports) {
    final CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    final JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    imports.classCountToUseImportWithWildcard().ifPresent(javaCodeStyleSettings::setClassCountToUseImportOnDemand);
    imports.namesCountToUseStaticImportWithWildcard().ifPresent(javaCodeStyleSettings::setNamesCountToUseImportOnDemand);
    CodeStyle.setMainProjectSettings(project, codeStyleSettings);
  }
}
