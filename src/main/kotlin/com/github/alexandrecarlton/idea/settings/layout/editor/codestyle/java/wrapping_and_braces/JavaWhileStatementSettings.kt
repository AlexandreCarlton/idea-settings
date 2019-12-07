package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaWhileStatementSettings(

    @JsonProperty("Force braces")
    val forceBraces: Force? = null
)
