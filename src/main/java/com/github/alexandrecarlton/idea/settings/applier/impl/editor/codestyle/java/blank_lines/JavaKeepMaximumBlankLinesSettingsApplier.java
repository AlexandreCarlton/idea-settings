package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import javax.inject.Inject;
import javax.inject.Named;

public class JavaKeepMaximumBlankLinesSettingsApplier implements SettingsApplier<JavaKeepMaximumBlankLinesSettings> {

  private final CommonCodeStyleSettings commonCodeStyleSettings;

  @Inject
  public JavaKeepMaximumBlankLinesSettingsApplier(@Named("java") CommonCodeStyleSettings commonCodeStyleSettings) {
    this.commonCodeStyleSettings = commonCodeStyleSettings;
  }

  @Override
  public void apply(JavaKeepMaximumBlankLinesSettings settings) {
    settings.inDeclarations()
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS = keep);
    settings.inCode()
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE = keep);
    settings.beforeRightBrace()
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE = keep);
    settings.betweenHeaderAndPackage()
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER = keep);
  }
}
