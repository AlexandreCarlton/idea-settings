package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideSettingsApplier(applier: Lazy<JavascriptInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
