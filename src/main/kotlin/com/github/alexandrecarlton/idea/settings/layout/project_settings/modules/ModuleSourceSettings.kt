package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules

import java.nio.file.Path

data class ModuleSourceSettings(

    val contentRoot: Path,

    val sources: List<String>? = null,

    val tests: List<String>? = null,

    val resources: List<String>? = null,

    val testResources: List<String>? = null,

    val excluded: List<String>? = null
)
