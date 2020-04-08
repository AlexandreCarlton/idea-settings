package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinTabsAndIndentsModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinTabsAndIndentsStyleSettingsApplier(applier: Lazy<KotlinTabsAndIndentsSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}

