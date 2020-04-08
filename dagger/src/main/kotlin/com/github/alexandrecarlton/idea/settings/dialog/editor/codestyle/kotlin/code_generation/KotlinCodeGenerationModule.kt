package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinCodeGenerationModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinCodeGenerationStyleSettingsApplier(applier: Lazy<KotlinCodeGenerationSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
