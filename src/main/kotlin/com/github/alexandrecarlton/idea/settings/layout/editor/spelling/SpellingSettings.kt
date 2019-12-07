package com.github.alexandrecarlton.idea.settings.layout.editor.spelling

import com.fasterxml.jackson.annotation.JsonProperty
import java.nio.file.Path

data class SpellingSettings(
    @JsonProperty("Dictionaries")
    val dictionaries: List<Path>? = null
)
