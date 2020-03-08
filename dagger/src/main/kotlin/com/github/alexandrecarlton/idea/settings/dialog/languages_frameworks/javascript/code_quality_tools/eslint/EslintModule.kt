package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object EslintModule : AbstractPluginModule() {

    @Provides
    fun provideEslintSettingsApplier(applier: Lazy<EslintSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
