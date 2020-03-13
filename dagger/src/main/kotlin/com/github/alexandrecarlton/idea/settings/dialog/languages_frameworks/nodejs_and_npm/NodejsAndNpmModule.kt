package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object NodejsAndNpmModule : AbstractPluginModule() {

    @Provides
    fun provideNodejsAndNpmSettingsApplier(applier: Lazy<NodejsAndNpmSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
