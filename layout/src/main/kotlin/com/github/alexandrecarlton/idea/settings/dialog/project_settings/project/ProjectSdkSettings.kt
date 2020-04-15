package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.fasterxml.jackson.annotation.JsonProperty

data class ProjectSdkSettings(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Type")
    val type: ProjectSdkType
)
