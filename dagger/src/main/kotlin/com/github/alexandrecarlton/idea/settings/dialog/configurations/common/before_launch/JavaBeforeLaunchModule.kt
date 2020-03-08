package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaBeforeLaunchModule : AbstractPluginModule() {

    @Provides
    fun provideBuildConfigurationSettings(buildConfigurationSettingsApplier: Lazy<BuildConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, buildConfigurationSettingsApplier)
}
