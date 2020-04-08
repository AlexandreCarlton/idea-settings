package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinFunctionDeclarationParametersSettings(

    @JsonProperty("Align when multiline")
    val alignWhenMultiline: Boolean? = null
)
