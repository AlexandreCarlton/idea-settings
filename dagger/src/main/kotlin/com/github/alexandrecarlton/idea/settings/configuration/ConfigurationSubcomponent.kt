package com.github.alexandrecarlton.idea.settings.configuration

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.BeforeLaunchModule
import dagger.BindsInstance
import dagger.Subcomponent

import javax.inject.Named

@Subcomponent(modules = [
    BeforeLaunchModule::class,
    ConfigurationModule::class])
interface ConfigurationSubcomponent {

    fun beforeLaunchConfigurationSettingsApplier(): SettingsApplier<BeforeLaunchConfigurationSettings>

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun configuration(@Named("configuration") name: String): Builder

        fun build(): ConfigurationSubcomponent
    }
}
