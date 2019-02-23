package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;

import javax.inject.Inject;

public class AutoImportSettingsApplier implements SettingsApplier<AutoImportSettings> {

  private final SettingsApplier<JavaAutoImportSettings> javaAutoImportSettingsApplier;

  @Inject
  public AutoImportSettingsApplier(SettingsApplier<JavaAutoImportSettings> javaAutoImportSettingsApplier) {
    this.javaAutoImportSettingsApplier = javaAutoImportSettingsApplier;
  }

  @Override
  public void apply(AutoImportSettings settings) {
    settings.java().ifPresent(javaAutoImportSettingsApplier::apply);
  }
}
