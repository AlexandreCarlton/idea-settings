package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaBinaryExpressionsSettings(

    @JsonProperty("Wrapping")
    val wrapping: Wrapping? = null,

    @JsonProperty("Align when multiline")
    val alignWhenMultiline: Boolean? = null
)
