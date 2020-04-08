package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinPackageToImportWithWildcard(

    @JsonProperty("Package")
    val packageToImport: String? = null,

    @JsonProperty("With Subpackages")
    val withSubpackages: Boolean? = null
)
