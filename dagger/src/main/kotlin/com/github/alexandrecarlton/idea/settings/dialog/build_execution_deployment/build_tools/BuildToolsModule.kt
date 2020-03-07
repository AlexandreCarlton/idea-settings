package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface BuildToolsModule {
    @Binds
    fun bindBuildToolsSettingsApplier(applier: BuildToolsSettingsApplier): SettingsApplier<BuildToolsSettings>
}
