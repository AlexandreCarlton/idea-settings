package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinKeepMaximumBlankLinesSettings(
    @JsonProperty("In declarations")
    val inDeclarations: Int? = null,

    @JsonProperty("In code")
    val inCode: Int? = null,

    @JsonProperty("Before '}'")
    val beforeRightBrace: Int? = null
)
