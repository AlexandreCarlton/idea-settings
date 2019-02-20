package com.github.alexandrecarlton.idea.settings.applier.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.openapi.project.Project;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;

// JavaImportsConfigurer
public class JavaImportsConfigurer {

  public void configure(Project project, JavaImportsSettings imports) {
    final CodeStyleSettings codeStyleSettings = CodeStyle.getSettings(project);
    final JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    imports.classCountToUseImportWithWildcard().ifPresent(javaCodeStyleSettings::setClassCountToUseImportOnDemand);
    imports.namesCountToUseStaticImportWithWildcard().ifPresent(javaCodeStyleSettings::setNamesCountToUseImportOnDemand);
    CodeStyle.setMainProjectSettings(project, codeStyleSettings);
  }
}
