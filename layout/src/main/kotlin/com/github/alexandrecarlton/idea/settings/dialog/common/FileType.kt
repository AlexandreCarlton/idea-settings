package com.github.alexandrecarlton.idea.settings.dialog.common

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * A representation of the filetypes supported by IntelliJ,
 * as you would find in a dropdown (with icons).
 */
enum class FileType {

    @JsonProperty("JavaScript")
    JAVASCRIPT,

    @JsonProperty("Less Style Sheet")
    LESS_STYLE_SHEET,

    @JsonProperty("React JSX")
    REACT_JSX,

    @JsonProperty("TypeScript")
    TYPESCRIPT,

    @JsonProperty("TypeScript JSX")
    TYPESCRIPT_JSX,
}
