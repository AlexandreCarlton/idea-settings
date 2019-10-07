package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;

import javax.inject.Inject;

public class LanguagesFrameworksSettingsApplier implements SettingsApplier<LanguagesFrameworksSettings> {

  private final SettingsApplier<JavascriptSettings> javascriptSettingsApplier;

  @Inject
  public LanguagesFrameworksSettingsApplier(SettingsApplier<JavascriptSettings> javascriptSettingsApplier) {
    this.javascriptSettingsApplier = javascriptSettingsApplier;
  }

  @Override
  public void apply(LanguagesFrameworksSettings settings) {
    settings.javascript().ifPresent(javascriptSettingsApplier::apply);
  }
}
