package com.github.alexandrecarlton.idea.settings.applier.impl.configurations;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationsSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;

import javax.inject.Inject;

public class ConfigurationsSettingsApplier implements SettingsApplier<ConfigurationsSettings> {

  private final SettingsApplier<RemoteSettings> remoteConfigurationApplier;

  @Inject
  public ConfigurationsSettingsApplier(SettingsApplier<RemoteSettings> remoteConfigurationApplier) {
    this.remoteConfigurationApplier = remoteConfigurationApplier;
  }

  @Override
  public void apply(ConfigurationsSettings settings) {
    settings.remote().forEach(remoteConfigurationApplier::apply);
  }

}
