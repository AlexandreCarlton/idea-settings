package com.github.alexandrecarlton.idea.settings.layout.project_settings

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings

data class ProjectSettingsSettings(
    @JsonProperty("Project")
    val project: ProjectSettings? = null,

    @JsonProperty("Modules")
    val modules: List<ModuleSettings>? = null
)
