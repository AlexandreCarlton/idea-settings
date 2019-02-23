package com.github.alexandrecarlton.idea.settings.applier.impl.editor;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;

import javax.inject.Inject;

public class EditorSettingsApplier implements SettingsApplier<EditorSettings> {

  private final SettingsApplier<GeneralSettings> generalSettingsApplier;
  private final SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier;

  @Inject
  public EditorSettingsApplier(SettingsApplier<GeneralSettings> generalSettingsApplier,
                               SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier) {
    this.generalSettingsApplier = generalSettingsApplier;
    this.codeStyleSettingsApplier = codeStyleSettingsApplier;
  }

  public void apply(EditorSettings configuration) {
    configuration.general().ifPresent(generalSettingsApplier::apply);
    configuration.codeStyle().ifPresent(codeStyleSettingsApplier::apply);
  }
}
