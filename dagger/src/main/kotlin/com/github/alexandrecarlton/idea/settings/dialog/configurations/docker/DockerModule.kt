package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Module
import dagger.Provides
import dagger.Lazy

@Module
object DockerModule : AbstractPluginModule() {
    @Provides
    internal fun provideDockerComposeConfigurationSettingsApplier(applier: Lazy<DockerComposeConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.DOCKER, applier)

    @Provides
    internal fun provideDockerImageConfigurationSettingsApplier(applier: Lazy<DockerImageConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.DOCKER, applier)
}
