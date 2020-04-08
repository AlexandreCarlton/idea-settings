package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.fasterxml.jackson.annotation.JsonProperty

data class AutoImportSettings(

    @JsonProperty("Java")
    val java: JavaAutoImportSettings? = null,

    @JsonProperty("Kotlin")
    val kotlin: KotlinAutoImportSettings? = null
)
