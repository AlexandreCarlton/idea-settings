package com.github.alexandrecarlton.idea.settings.configuration

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BeforeLaunchConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.RunAnotherConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings
import dagger.Binds
import dagger.Module

@Module
interface SettingsApplierModule {

    @Binds
    fun provideBeforeLaunchConfigurationSettingsApplier(applier: BeforeLaunchConfigurationSettingsApplier): SettingsApplier<BeforeLaunchConfigurationSettings>

    @Binds
    fun provideRunAnotherConfigurationSettingsApplier(runAnotherConfigurationSettingsApplier: RunAnotherConfigurationSettingsApplier): SettingsApplier<RunAnotherConfigurationSettings>
}
