package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinRedundantConstructsInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinRedundantConstructsInspectionsSettingsApplier(applier: Lazy<KotlinRedundantConstructsInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)

    @Provides
    fun provideRedundantSemicolonInspectionSettingsApplier(applier: Lazy<RedundantSemicolonInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)

    @Provides
    fun provideUnusedImportDirectiveInspectionSettingsApplier(applier: Lazy<UnusedImportDirectiveInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
