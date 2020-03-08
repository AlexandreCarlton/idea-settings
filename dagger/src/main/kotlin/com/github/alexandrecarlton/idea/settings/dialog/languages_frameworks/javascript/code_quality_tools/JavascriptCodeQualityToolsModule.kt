package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptCodeQualityToolsModule : AbstractPluginModule() {

    @Provides
    fun provideJavascriptCodeQualityToolsSettingsApplier(applier: Lazy<JavascriptCodeQualityToolsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
