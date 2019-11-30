package com.github.alexandrecarlton.idea.settings.layout.common

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * A representation of the filetypes supported by IntelliJ,
 * as you would find in a dropdown (with icons).
 */
enum class FileType {

    @JsonProperty("JavaScript")
    JAVASCRIPT
}
