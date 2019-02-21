package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;

import javax.inject.Inject;

public class JavaCodeStyleSettingsApplier implements SettingsApplier<JavaCodeStyleSettings> {

  private final SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier;

  @Inject
  public JavaCodeStyleSettingsApplier(SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier) {
    this.javaImportsSettingsApplier = javaImportsSettingsApplier;
  }

  public void apply(JavaCodeStyleSettings java) {
    java.imports().ifPresent(javaImportsSettingsApplier::apply);
  }
}
