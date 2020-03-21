package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object SonarlintModule : AbstractPluginModule() {
    @Provides
    fun provideSonarlintSettingsApplier(applier: Lazy<SonarlintSettingsApplier>) =
        provideIfLoaded(Plugin.SONARLINT, applier)
}
