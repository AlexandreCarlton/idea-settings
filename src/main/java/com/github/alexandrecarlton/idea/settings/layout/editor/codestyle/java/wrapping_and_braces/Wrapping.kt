package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

enum class Wrapping {
    @JsonProperty("Do not wrap")
    DO_NOT_WRAP,

    @JsonProperty("Wrap if long")
    WRAP_IF_LONG,

    @JsonProperty("Chop down if long")
    CHOP_DOWN_IF_LONG,

    @JsonProperty("Wrap always")
    WRAP_ALWAYS
}
