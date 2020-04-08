package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinCommentCodeSettings(

    @JsonProperty("Line comment at first column")
    val lineCommentAtFirstColumn: Boolean? = null,

    @JsonProperty("Add a space at comment start")
    val addASpaceAtCommentStart: Boolean? = null,

    @JsonProperty("Block comment at first column")
    val blockCommentAtFirstColumn: Boolean? = null
)
