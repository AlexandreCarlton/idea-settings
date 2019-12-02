package com.github.alexandrecarlton.idea.settings.layout.project_settings

import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings

data class ProjectSettingsSettings(
    val project: ProjectSettings? = null,

    val modules: List<ModuleSettings>? = null
)
