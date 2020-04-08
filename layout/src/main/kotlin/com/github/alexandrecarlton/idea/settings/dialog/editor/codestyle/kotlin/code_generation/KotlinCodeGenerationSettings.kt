package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinCodeGenerationSettings(
    @JsonProperty("Comment Code")
    val commentCode: KotlinCommentCodeSettings? = null
)
