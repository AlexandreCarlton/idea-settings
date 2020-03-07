package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object MavenModule : AbstractPluginModule() {

    @Provides
    fun provideMavenSettingsApplier(applier: Lazy<MavenSettingsApplier>) = provideIfLoaded(Plugin.MAVEN, applier)

    @Provides
    fun provideMavenImportingSettingsApplier(applier: Lazy<MavenImportingSettingsApplier>) = provideIfLoaded(Plugin.MAVEN, applier)

}
