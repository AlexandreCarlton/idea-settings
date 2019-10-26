package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import dagger.BindsInstance;
import dagger.Subcomponent;

import javax.inject.Named;

@Subcomponent(modules = {
  ConfigurationModule.class,
  OptionalSettingsApplierModule.class,
  SettingsApplierModule.class})
public interface ConfigurationSubcomponent {

  SettingsApplier<BeforeLaunchConfigurationSettings> beforeLaunchConfigurationSettingsApplier();

  @Subcomponent.Builder
  interface Builder {
    @BindsInstance
    ConfigurationSubcomponent.Builder configuration(@Named("configuration") String name);
    ConfigurationSubcomponent build();
  }
}
