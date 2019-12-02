package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules

data class ModuleSettings(

    val name: String,

    val sources: List<ModuleSourceSettings>? = null
)
