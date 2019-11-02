package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;

import javax.inject.Inject;

public class JavaCodeStyleSettingsApplier implements SettingsApplier<JavaCodeStyleSettings> {

  private final SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier;
  private final SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier;

  @Inject
  public JavaCodeStyleSettingsApplier(SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier,
                                      SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier) {
    this.javaArrangementSettingsApplier = javaArrangementSettingsApplier;
    this.javaImportsSettingsApplier = javaImportsSettingsApplier;
  }

  public void apply(JavaCodeStyleSettings java) {
    java.arrangement().ifPresent(javaArrangementSettingsApplier::apply);
    java.imports().ifPresent(javaImportsSettingsApplier::apply);
  }
}
