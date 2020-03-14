package com.github.alexandrecarlton.idea.settings.dialog.configurations.npm

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object NpmConfigurationModule : AbstractPluginModule() {

    @Provides
    fun provideNpmConfigurationSettingsApplier(applier: Lazy<NpmConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
