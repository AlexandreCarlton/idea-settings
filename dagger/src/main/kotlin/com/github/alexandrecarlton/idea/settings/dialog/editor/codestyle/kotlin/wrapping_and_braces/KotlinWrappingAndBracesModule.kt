package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinWrappingAndBracesModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinWrappingAndBracesStyleSettingsApplier(applier: Lazy<KotlinWrappingAndBracesSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}

