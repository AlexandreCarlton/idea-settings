package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaAutoImportSettings(

    @JsonProperty("Optimize imports on the fly (for current project)")
    val optimizeImportsOnTheFly: Boolean? = null,

    @JsonProperty("Exclude from import and completion")
    val excludeFromImportAndCompletion: List<String>? = null
)
