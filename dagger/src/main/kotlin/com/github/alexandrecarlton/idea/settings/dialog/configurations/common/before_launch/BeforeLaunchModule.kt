package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module(includes = [JavaBeforeLaunchModule::class, MavenBeforeLaunchModule::class])
interface BeforeLaunchModule {

    @Binds
    fun provideBeforeLaunchConfigurationSettingsApplier(applier: BeforeLaunchConfigurationSettingsApplier): SettingsApplier<BeforeLaunchConfigurationSettings>

    @Binds
    fun provideRunAnotherConfigurationSettingsApplier(applier: RunAnotherConfigurationSettingsApplier): SettingsApplier<RunAnotherConfigurationSettings>
}
