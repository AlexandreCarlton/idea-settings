package com.github.alexandrecarlton.idea.settings.module

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules.ModuleSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings

import dagger.Binds
import dagger.Module

@Module
interface SettingsApplierModule {

    @Binds
    fun provideModuleSettingsApplier(applier: ModuleSettingsApplier): SettingsApplier<ModuleSettings>
}
