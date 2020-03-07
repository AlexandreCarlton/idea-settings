package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class ModuleSourceSettings(

    @JsonProperty("Content Root")
    val contentRoot: File,

    @JsonProperty("Sources")
    val sources: List<SourceRootSettings>? = null,

    @JsonProperty("Tests")
    val tests: List<SourceRootSettings>? = null,

    @JsonProperty("Resources")
    val resources: List<ResourceRootSettings>? = null,

    @JsonProperty("Test Resources")
    val testResources: List<ResourceRootSettings>? = null,

    @JsonProperty("Excluded")
    val excluded: List<String>? = null
)
