package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BeforeLaunchConfigurationSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import dagger.Binds;
import dagger.Module;

@Module
public interface SettingsApplierModule {

  @Binds
  SettingsApplier<BeforeLaunchConfigurationSettings> provideBeforeLaunchConfigurationSettingsApplier(BeforeLaunchConfigurationSettingsApplier applier);


}
