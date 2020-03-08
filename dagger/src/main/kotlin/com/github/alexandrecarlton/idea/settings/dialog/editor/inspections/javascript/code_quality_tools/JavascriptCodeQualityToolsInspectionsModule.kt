package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptCodeQualityToolsInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideJavascriptCodeQualityToolsInspectionsSettingsApplier(applier: Lazy<JavascriptCodeQualityToolsInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)

    @Provides
    fun provideEslintInspectionSettingsApplier(applier: Lazy<EslintInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
