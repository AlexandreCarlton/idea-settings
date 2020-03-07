package com.github.alexandrecarlton.idea.settings.dialog.tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface ToolsModule {

    @Binds
    fun bindToolsSettingsApplier(applier: ToolsSettingsApplier): SettingsApplier<ToolsSettings>
}
