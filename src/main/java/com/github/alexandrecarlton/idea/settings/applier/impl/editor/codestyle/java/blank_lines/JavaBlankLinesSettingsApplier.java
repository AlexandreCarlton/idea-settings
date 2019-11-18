package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings;
import javax.inject.Inject;

public class JavaBlankLinesSettingsApplier implements SettingsApplier<JavaBlankLinesSettings> {

  private final SettingsApplier<JavaKeepMaximumBlankLinesSettings> javaKeepMaximumBlankLinesSettingsApplier;
  private final SettingsApplier<JavaMinimumBlankLinesSettings> javaMinimumBlankLinesSettingsApplier;

  @Inject
  public JavaBlankLinesSettingsApplier(SettingsApplier<JavaKeepMaximumBlankLinesSettings> javaKeepMaximumBlankLinesSettingsApplier,
                                       SettingsApplier<JavaMinimumBlankLinesSettings> javaMinimumBlankLinesSettingsApplier) {
    this.javaKeepMaximumBlankLinesSettingsApplier = javaKeepMaximumBlankLinesSettingsApplier;
    this.javaMinimumBlankLinesSettingsApplier = javaMinimumBlankLinesSettingsApplier;
  }

  @Override
  public void apply(JavaBlankLinesSettings settings) {
    settings.keepMaximumBlankLines().ifPresent(javaKeepMaximumBlankLinesSettingsApplier::apply);
    settings.minimumBlankLines().ifPresent(javaMinimumBlankLinesSettingsApplier::apply);
  }
}
