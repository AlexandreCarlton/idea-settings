package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinImportsModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinImportsStyleSettingsApplier(applier: Lazy<KotlinImportsSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
