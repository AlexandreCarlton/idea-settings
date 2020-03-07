package com.github.alexandrecarlton.idea.settings.dialog.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface ProjectSettingsModule {

    @Binds
    fun bindProjectSettingsSettingsApplier(applier: ProjectSettingsSettingsApplier): SettingsApplier<ProjectSettingsSettings>
}
