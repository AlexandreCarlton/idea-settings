package com.github.alexandrecarlton.idea.settings.dialog.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object ShellScriptModule : AbstractPluginModule() {
    @Provides
    fun provideShellScriptConfigurationSettingsApplier(applier: Lazy<ShellScriptConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.SHELL_SCRIPT, applier)
}
