package com.github.alexandrecarlton.idea.settings.dialog.other_settings.save_actions

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object SaveActionsModule : AbstractPluginModule() {

    @Provides
    internal fun provideSaveActionsSettingsApplier(applier: Lazy<SaveActionsSettingsApplier>) =
        provideIfLoaded(Plugin.SAVE_ACTIONS, applier)
}
