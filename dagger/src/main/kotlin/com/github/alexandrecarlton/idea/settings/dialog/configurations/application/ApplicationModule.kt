package com.github.alexandrecarlton.idea.settings.dialog.configurations.application

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Provides
import dagger.Module
import dagger.Lazy

@Module
class ApplicationModule : AbstractPluginModule() {
    @Provides
    fun provideApplicationConfigurationSettingsApplier(applier: Lazy<ApplicationConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
