package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

enum class Force {
    @JsonProperty("Do not force")
    DO_NOT_FORCE,

    @JsonProperty("When multiline")
    WHEN_MULTILINE,

    @JsonProperty("Always")
    ALWAYS
}
