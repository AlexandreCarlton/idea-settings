package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;

import javax.inject.Inject;

public class LanguagesFrameworksSettingsApplier implements SettingsApplier<LanguagesFrameworksSettings> {

  private final SettingsApplier<JavascriptSettings> javascriptSettingsApplier;
  private final SettingsApplier<SqlDialectsSettings> sqlDialectsSettingsApplier;

  @Inject
  public LanguagesFrameworksSettingsApplier(SettingsApplier<JavascriptSettings> javascriptSettingsApplier,
                                            SettingsApplier<SqlDialectsSettings> sqlDialectsSettingsApplier) {
    this.javascriptSettingsApplier = javascriptSettingsApplier;
    this.sqlDialectsSettingsApplier = sqlDialectsSettingsApplier;
  }

  @Override
  public void apply(LanguagesFrameworksSettings settings) {
    settings.javascript().ifPresent(javascriptSettingsApplier::apply);
    settings.sqlDialects().ifPresent(sqlDialectsSettingsApplier::apply);
  }
}
