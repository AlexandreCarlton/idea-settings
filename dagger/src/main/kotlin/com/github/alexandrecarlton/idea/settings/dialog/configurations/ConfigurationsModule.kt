package com.github.alexandrecarlton.idea.settings.dialog.configurations

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface ConfigurationsModule {
    @Binds
    fun bindConfigurationsSettingsApplier(applier: ConfigurationsSettingsApplier): SettingsApplier<ConfigurationSettings>
}
