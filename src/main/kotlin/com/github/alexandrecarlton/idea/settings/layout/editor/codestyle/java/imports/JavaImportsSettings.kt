package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaImportsSettings(

    @JsonProperty("Class count to use import with '*'")
    val classCountToUseImportWithWildcard: Int? = null,

    @JsonProperty("Names count to use static import with '*'")
    val namesCountToUseStaticImportWithWildcard: Int? = null
)
