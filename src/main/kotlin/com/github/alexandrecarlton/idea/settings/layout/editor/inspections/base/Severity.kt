package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base

import com.fasterxml.jackson.annotation.JsonProperty

enum class Severity {
    @JsonProperty("Error")
    ERROR,

    @JsonProperty("Warning")
    WARNING,

    @JsonProperty("Weak Warning")
    WEAK_WARNING,

    @JsonProperty("Sever Problem")
    SERVER_PROBLEM,

    @JsonProperty("Typo")
    TYPO,

    @JsonProperty("No highlighting, only fix")
    NO_HIGHLIGHTING_ONLY_FIX
}
