package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty

data class ModuleSettings(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Sources")
    val sources: List<ModuleSourceSettings>? = null
)
