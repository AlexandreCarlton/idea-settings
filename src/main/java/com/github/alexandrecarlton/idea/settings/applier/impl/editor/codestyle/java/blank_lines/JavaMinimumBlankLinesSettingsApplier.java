package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import javax.inject.Inject;
import javax.inject.Named;

public class JavaMinimumBlankLinesSettingsApplier implements SettingsApplier<JavaMinimumBlankLinesSettings> {

  private final CommonCodeStyleSettings commonCodeStyleSettings;
  private final JavaCodeStyleSettings javaCodeStyleSettings;

  @Inject
  public JavaMinimumBlankLinesSettingsApplier(@Named("java") CommonCodeStyleSettings commonCodeStyleSettings,
                                              JavaCodeStyleSettings javaCodeStyleSettings) {
    this.commonCodeStyleSettings = commonCodeStyleSettings;
    this.javaCodeStyleSettings = javaCodeStyleSettings;
  }
  @Override
  public void apply(JavaMinimumBlankLinesSettings settings) {
    settings.beforePackageStatement()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_BEFORE_PACKAGE = blankLines);
    settings.afterPackageStatement()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AFTER_PACKAGE = blankLines);
    settings.beforeImports()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_BEFORE_IMPORTS = blankLines);
    settings.afterImports()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AFTER_IMPORTS = blankLines);
    settings.aroundClass()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AROUND_CLASS = blankLines);
    settings.afterClassHeader()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER = blankLines);
    settings.beforeClassEnd()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_BEFORE_CLASS_END = blankLines);
    settings.afterAnonymousClassHeader()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER = blankLines);
    settings.aroundFieldInInterface()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD_IN_INTERFACE = blankLines);
    settings.aroundField()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD = blankLines);
    settings.aroundMethodInInterface()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD_IN_INTERFACE = blankLines);
    settings.aroundMethod()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD = blankLines);
    settings.beforeMethodBody()
        .ifPresent(blankLines -> commonCodeStyleSettings.BLANK_LINES_BEFORE_METHOD_BODY = blankLines);
    settings.aroundInitializer()
        .ifPresent(blankLines -> javaCodeStyleSettings.BLANK_LINES_AROUND_INITIALIZER = blankLines);
  }
}
