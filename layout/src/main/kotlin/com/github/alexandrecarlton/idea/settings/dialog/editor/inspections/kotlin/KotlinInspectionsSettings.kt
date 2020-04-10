package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.KotlinRedundantConstructsInspectionsSettings

data class KotlinInspectionsSettings(
    @JsonProperty("Redundant constructs")
    val redundantConstructs: KotlinRedundantConstructsInspectionsSettings? = null
)
