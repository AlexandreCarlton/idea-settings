package com.github.alexandrecarlton.idea.settings.dialog.editor.spelling

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class SpellingSettings(
    @JsonProperty("Dictionaries")
    val dictionaries: List<File>? = null,

    @JsonProperty("Accepted Words")
    val acceptedWords: List<String>? = null
)
