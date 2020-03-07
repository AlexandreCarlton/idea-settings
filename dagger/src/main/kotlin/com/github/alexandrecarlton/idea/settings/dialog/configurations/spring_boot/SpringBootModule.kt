package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object SpringBootModule : AbstractPluginModule() {
    @Provides
    internal fun provideSpringBootSettingsApplier(applier: Lazy<SpringBootSettingsApplier>) =
        provideIfLoaded(Plugin.SPRING_BOOT, applier)
}
