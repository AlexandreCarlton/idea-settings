package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptCodeQualityToolsInspectionsModule : AbstractPluginModule() {

    // Use a shorter name as we get "File name too long" errors.
    @Provides
    internal fun provideJavascript(applier: Lazy<JavascriptCodeQualityToolsInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)

    @Provides
    internal fun provideEslint(applier: Lazy<EslintInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
