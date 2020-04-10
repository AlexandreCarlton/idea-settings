package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinInspectionsSettingsApplier(applier: Lazy<KotlinInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
