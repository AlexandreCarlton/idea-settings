package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface ProjectSettingsProjectModule {

    @Binds
    fun bindProjectSettingsApplier(applier: ProjectSettingsApplier): SettingsApplier<ProjectSettings>
}
