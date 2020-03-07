package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.fasterxml.jackson.annotation.JsonProperty

data class ProjectSettings(

    @JsonProperty("Project name")
    val projectName: String? = null,

    @JsonProperty("Project SDK")
    val projectSdk: String? = null,

    @JsonProperty("Project language level")
    val projectLanguageLevel: ProjectLanguageLevel? = null
)
