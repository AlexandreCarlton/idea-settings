package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptLanguagesFrameworksModule : AbstractPluginModule() {

    @Provides
    fun provideJavascriptSettingsApplier(applier: Lazy<JavascriptSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
