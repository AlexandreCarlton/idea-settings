package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinCodeStyleModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinCodeStyleSettingsApplier(applier: Lazy<KotlinCodeStyleSettingsApplier>) =
        KotlinCodeStyleModule.provideIfLoaded(Plugin.KOTLIN, applier)
}
