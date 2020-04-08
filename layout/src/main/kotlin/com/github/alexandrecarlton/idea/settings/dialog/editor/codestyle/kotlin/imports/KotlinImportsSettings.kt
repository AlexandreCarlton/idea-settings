package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinImportsSettings(

    @JsonProperty("Top-level Symbols")
    val topLevelSymbols: KotlinImportWithWildcardSettings? = null,

    @JsonProperty("Java Statics and Enum Members")
    val javaStaticsAndEnumMembers: KotlinImportWithWildcardSettings? = null,

    @JsonProperty("Packages to Use Import with '*'")
    val packagesToUseImportWithWildcard: List<KotlinPackageToImportWithWildcard>? = null
)
