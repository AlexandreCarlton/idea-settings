package com.github.alexandrecarlton.idea.settings.configuration

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import dagger.BindsInstance
import dagger.Subcomponent

import javax.inject.Named

@Subcomponent(modules = [ConfigurationModule::class, OptionalSettingsApplierModule::class, SettingsApplierModule::class])
interface ConfigurationSubcomponent {

    fun beforeLaunchConfigurationSettingsApplier(): SettingsApplier<BeforeLaunchConfigurationSettings>

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun configuration(@Named("configuration") name: String): Builder

        fun build(): ConfigurationSubcomponent
    }
}
