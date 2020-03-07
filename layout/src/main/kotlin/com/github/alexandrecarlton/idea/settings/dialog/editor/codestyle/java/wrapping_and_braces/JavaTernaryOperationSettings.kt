package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaTernaryOperationSettings(

    @JsonProperty("Wrapping")
    val wrapping: Wrapping? = null
)
