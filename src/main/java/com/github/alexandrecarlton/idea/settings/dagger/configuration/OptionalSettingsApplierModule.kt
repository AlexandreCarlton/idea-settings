package com.github.alexandrecarlton.idea.settings.dagger.configuration

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BuildConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.RunMavenGoalSettingsApplier
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
class OptionalSettingsApplierModule {

    private val LOG = Logger.getInstance(OptionalSettingsApplierModule::class.java)

    @Provides
    internal fun provideRunMavenGoalSettingsApplier(runMavenGoalSettingsApplier: Lazy<RunMavenGoalSettingsApplier>) =
        provideIfLoaded(Plugin.MAVEN, runMavenGoalSettingsApplier)

    @Provides
    internal fun provideBuildConfigurationSettings(buildConfigurationSettingsApplier: Lazy<BuildConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, buildConfigurationSettingsApplier)

    private fun <T> provideIfLoaded(plugin: Plugin, settingsApplier: Lazy<out SettingsApplier<T>>): SettingsApplier<T> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id)))
            settingsApplier.get()
        else
            SettingsApplier { LOG.warn("Unable to apply certain settings as plugin '" + plugin.pluginName + "' is not installed.") }
}
