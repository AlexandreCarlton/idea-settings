package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;

import javax.inject.Inject;

public class OtherSettingsApplier implements SettingsApplier<OtherSettings> {

  private final SettingsApplier<CheckstyleSettings> checkstyleSettingsApplier;

  @Inject
  public OtherSettingsApplier(SettingsApplier<CheckstyleSettings> checkstyleSettingsApplier) {
    this.checkstyleSettingsApplier = checkstyleSettingsApplier;
  }

  @Override
  public void apply(OtherSettings settings) {
    settings.checkstyle().ifPresent(checkstyleSettingsApplier::apply);
  }
}
