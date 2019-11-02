package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings;
import javax.inject.Inject;

public class JavascriptCodeStyleSettingsApplier implements SettingsApplier<JavascriptCodeStyleSettings> {

  private final SettingsApplier<JavascriptImportsSettings> javascriptImportsSettingsApplier;

  @Inject
  public JavascriptCodeStyleSettingsApplier(SettingsApplier<JavascriptImportsSettings> javascriptImportsSettingsApplier) {
    this.javascriptImportsSettingsApplier = javascriptImportsSettingsApplier;
  }

  @Override
  public void apply(JavascriptCodeStyleSettings settings) {
    settings.imports().ifPresent(javascriptImportsSettingsApplier::apply);
  }
}
