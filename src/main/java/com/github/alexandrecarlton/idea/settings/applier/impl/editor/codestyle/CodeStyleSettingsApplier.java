package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings;
import javax.inject.Inject;

public class CodeStyleSettingsApplier implements SettingsApplier<CodeStyleSettings> {

  private final SettingsApplier<JavaCodeStyleSettings> javaCodeStyleSettingsApplier;
  private final SettingsApplier<JavascriptCodeStyleSettings> javascriptCodeStyleSettingsApplier;

  @Inject
  public CodeStyleSettingsApplier(SettingsApplier<JavaCodeStyleSettings> javaCodeStyleSettingsApplier,
                                  SettingsApplier<JavascriptCodeStyleSettings> javascriptCodeStyleSettingsApplier) {
    this.javaCodeStyleSettingsApplier = javaCodeStyleSettingsApplier;
    this.javascriptCodeStyleSettingsApplier = javascriptCodeStyleSettingsApplier;
  }

  public void apply(CodeStyleSettings configuration) {
    configuration.java().ifPresent(javaCodeStyleSettingsApplier::apply);
    configuration.javascript().ifPresent(javascriptCodeStyleSettingsApplier::apply);
  }
}
