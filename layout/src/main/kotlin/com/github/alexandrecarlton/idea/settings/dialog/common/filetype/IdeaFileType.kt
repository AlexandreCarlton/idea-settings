package com.github.alexandrecarlton.idea.settings.dialog.common.filetype

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * A representation of the filetypes supported by IntelliJ,
 * as you would find in a dropdown (with icons).
 */
enum class IdeaFileType {

    @JsonProperty("Cascading Style Sheet")
    CASCADING_STYLE_SHEET,

    @JsonProperty("JavaScript")
    JAVASCRIPT,

    @JsonProperty("JSON")
    JSON,

    @JsonProperty("Less Style Sheet")
    LESS_STYLE_SHEET,

    @JsonProperty("Markdown")
    MARKDOWN,

    @JsonProperty("React JSX")
    REACT_JSX,

    @JsonProperty("TypeScript")
    TYPESCRIPT,

    @JsonProperty("TypeScript JSX")
    TYPESCRIPT_JSX,
}
