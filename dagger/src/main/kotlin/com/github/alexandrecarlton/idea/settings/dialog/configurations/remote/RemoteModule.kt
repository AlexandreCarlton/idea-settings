package com.github.alexandrecarlton.idea.settings.dialog.configurations.remote

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object RemoteModule : AbstractPluginModule() {
    @Provides
    internal fun provideRemoteSettingsApplier(applier: Lazy<RemoteSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
