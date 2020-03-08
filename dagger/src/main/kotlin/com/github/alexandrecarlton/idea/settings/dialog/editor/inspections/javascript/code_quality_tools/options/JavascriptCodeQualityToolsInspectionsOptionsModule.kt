package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.options

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavascriptCodeQualityToolsInspectionsOptionsModule : AbstractPluginModule() {

    @Provides
    fun provideEslintInspectionOptionsSettingsApplier(applier: Lazy<EslintInspectionOptionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, applier)
}
