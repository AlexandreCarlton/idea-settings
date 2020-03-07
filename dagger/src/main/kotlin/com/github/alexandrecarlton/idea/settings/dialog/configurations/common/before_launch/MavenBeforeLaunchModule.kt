package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object MavenBeforeLaunchModule : AbstractPluginModule() {

    @Provides
    internal fun provideRunMavenGoalSettingsApplier(runMavenGoalSettingsApplier: Lazy<RunMavenGoalSettingsApplier>) =
        provideIfLoaded(Plugin.MAVEN, runMavenGoalSettingsApplier)
}
