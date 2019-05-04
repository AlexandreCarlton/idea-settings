package com.github.alexandrecarlton.idea.settings.applier.impl.editor;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;

import javax.inject.Inject;

public class EditorSettingsApplier implements SettingsApplier<EditorSettings> {

  private final SettingsApplier<GeneralSettings> generalSettingsApplier;
  private final SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier;
  private final SettingsApplier<SpellingSettings> spellingSettingsApplier;

  @Inject
  public EditorSettingsApplier(SettingsApplier<GeneralSettings> generalSettingsApplier,
                               SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier,
                               SettingsApplier<SpellingSettings> spellingSettingsApplier) {
    this.generalSettingsApplier = generalSettingsApplier;
    this.codeStyleSettingsApplier = codeStyleSettingsApplier;
    this.spellingSettingsApplier = spellingSettingsApplier;
  }

  public void apply(EditorSettings settings) {
    settings.general().ifPresent(generalSettingsApplier::apply);
    settings.codeStyle().ifPresent(codeStyleSettingsApplier::apply);
    settings.spelling().ifPresent(spellingSettingsApplier::apply);
  }
}
