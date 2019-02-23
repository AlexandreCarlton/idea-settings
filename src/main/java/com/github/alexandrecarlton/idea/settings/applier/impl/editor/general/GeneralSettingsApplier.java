package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings;

import javax.inject.Inject;

public class GeneralSettingsApplier implements SettingsApplier<GeneralSettings> {

  private final SettingsApplier<AutoImportSettings> autoImportSettingsSettingsApplier;

  @Inject
  public GeneralSettingsApplier(SettingsApplier<AutoImportSettings> autoImportSettingsSettingsApplier) {
    this.autoImportSettingsSettingsApplier = autoImportSettingsSettingsApplier;
  }

  @Override
  public void apply(GeneralSettings settings) {
    settings.autoImport().ifPresent(autoImportSettingsSettingsApplier::apply);
  }
}
