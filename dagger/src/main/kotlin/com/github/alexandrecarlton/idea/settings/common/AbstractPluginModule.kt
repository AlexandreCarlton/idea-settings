package com.github.alexandrecarlton.idea.settings.common

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import dagger.Lazy

abstract class AbstractPluginModule {

    private val LOG = Logger.getInstance(AbstractPluginModule::class.java)

    protected fun <T> provideIfLoaded(plugin: Plugin, settingsApplier: Lazy<out SettingsApplier<T>>): SettingsApplier<T> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id)))
            settingsApplier.get()
        else
            object : SettingsApplier<T> {
                override fun apply(settings: T) {
                    LOG.warn("Unable to apply certain settings as plugin '${plugin.pluginName}' is not installed.")
                }
            }
}
