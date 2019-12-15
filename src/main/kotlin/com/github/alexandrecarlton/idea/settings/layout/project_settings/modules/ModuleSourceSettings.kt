package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class ModuleSourceSettings(

    @JsonProperty("Content Root")
    val contentRoot: File,

    @JsonProperty("Sources")
    val sources: List<String>? = null,

    @JsonProperty("Tests")
    val tests: List<String>? = null,

    @JsonProperty("Resources")
    val resources: List<String>? = null,

    @JsonProperty("Test Resources")
    val testResources: List<String>? = null,

    @JsonProperty("Excluded")
    val excluded: List<String>? = null
)
