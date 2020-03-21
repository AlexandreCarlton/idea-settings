package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object SonarlintProjectSettingsModule : AbstractPluginModule() {
    @Provides
    fun provideSonarlintProjectSettingsSettingsApplier(applier: Lazy<SonarlintProjectSettingsSettingsApplier>) =
        provideIfLoaded(Plugin.SONARLINT, applier)
}
