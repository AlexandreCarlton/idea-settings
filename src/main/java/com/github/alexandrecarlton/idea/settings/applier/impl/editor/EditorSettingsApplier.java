package com.github.alexandrecarlton.idea.settings.applier.impl.editor;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;

import javax.inject.Inject;

public class EditorSettingsApplier implements SettingsApplier<EditorSettings> {

  private final SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier;

  @Inject
  public EditorSettingsApplier(SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier) {
    this.codeStyleSettingsApplier = codeStyleSettingsApplier;
  }

  public void apply(EditorSettings configuration) {
    configuration.codeStyle().ifPresent(codeStyleSettingsApplier::apply);
  }
}