package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface ProjectSettingsModulesModule {

    @Binds
    fun bindModuleSettingsApplier(applier: ModuleSettingsApplier): SettingsApplier<ModuleSettings>
}
