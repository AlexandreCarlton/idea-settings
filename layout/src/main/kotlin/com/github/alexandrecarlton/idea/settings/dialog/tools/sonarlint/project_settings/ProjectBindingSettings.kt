package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonProperty

data class ProjectBindingSettings(

    @JsonProperty("Connection")
    val connection: String? = null,

    @JsonProperty("Project")
    val project: String? = null
)
