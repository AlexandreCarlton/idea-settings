package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BeforeLaunchConfigurationSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.RunAnotherConfigurationSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings;
import dagger.Binds;
import dagger.Module;

@Module
public interface SettingsApplierModule {

  @Binds
  SettingsApplier<BeforeLaunchConfigurationSettings> provideBeforeLaunchConfigurationSettingsApplier(BeforeLaunchConfigurationSettingsApplier applier);

  @Binds
  SettingsApplier<RunAnotherConfigurationSettings> provideRunAnotherConfigurationSettingsApplier(RunAnotherConfigurationSettingsApplier runAnotherConfigurationSettingsApplier);

}
