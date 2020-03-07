package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptCodeStyleModule : AbstractPluginModule() {

    @Provides
    internal fun provideJavascriptCodeStyleSettingsApplier(applier: Lazy<JavascriptCodeStyleSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)

    @Provides
    internal fun provideJavascriptImportsSettingsApplier(applier: Lazy<JavascriptImportsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
