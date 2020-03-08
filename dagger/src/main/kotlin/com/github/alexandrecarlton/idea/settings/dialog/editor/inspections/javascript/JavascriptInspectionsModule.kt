package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptInspectionsModule : AbstractPluginModule() {

    @Provides
    internal fun provide(applier: Lazy<JavascriptInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
