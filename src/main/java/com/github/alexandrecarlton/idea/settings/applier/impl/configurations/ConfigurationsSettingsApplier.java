package com.github.alexandrecarlton.idea.settings.applier.impl.configurations;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationsSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;

import javax.inject.Inject;

public class ConfigurationsSettingsApplier implements SettingsApplier<ConfigurationsSettings> {

  private final SettingsApplier<RemoteSettings> remoteConfigurationApplier;
  private final SettingsApplier<SpringBootSettings> springBootConfigurationApplier;

  @Inject
  public ConfigurationsSettingsApplier(SettingsApplier<RemoteSettings> remoteConfigurationApplier, SettingsApplier<SpringBootSettings> springBootConfigurationApplier) {
    this.remoteConfigurationApplier = remoteConfigurationApplier;
    this.springBootConfigurationApplier = springBootConfigurationApplier;
  }

  @Override
  public void apply(ConfigurationsSettings settings) {
    settings.remote().forEach(remoteConfigurationApplier::apply);
    settings.springBoot().forEach(springBootConfigurationApplier::apply);
  }

}
