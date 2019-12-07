package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import

import com.fasterxml.jackson.annotation.JsonProperty

data class AutoImportSettings(

    @JsonProperty("Java")
    val java: JavaAutoImportSettings? = null
)
