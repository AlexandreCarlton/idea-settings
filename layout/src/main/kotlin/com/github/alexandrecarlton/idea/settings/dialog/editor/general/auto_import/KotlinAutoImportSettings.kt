package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinAutoImportSettings(

    @JsonProperty("Optimize imports on the fly (for current project)")
    val optimizeImportsOnTheFly: Boolean? = null
)
