package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces.KotlinFunctionDeclarationParametersSettings

data class KotlinWrappingAndBracesSettings(
    @JsonProperty("Function declaration parameters")
    val functionDeclarationParameters: KotlinFunctionDeclarationParametersSettings? = null
)
