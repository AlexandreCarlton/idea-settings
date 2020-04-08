package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinBlankLinesModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinBlankLinesStyleSettingsApplier(applier: Lazy<KotlinBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
