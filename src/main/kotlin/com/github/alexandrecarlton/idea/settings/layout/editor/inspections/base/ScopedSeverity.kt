package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base

import com.fasterxml.jackson.annotation.JsonProperty

data class ScopedSeverity<Options>(

    @JsonProperty("Scope")
    val scope: Scope,

    @JsonProperty("Severity")
    val severity: Severity,

    /**
     * Represents the options that can be configured at each scope.
     * If no options are available, we'll leave this as [Unit].
     */
    @JsonProperty("Options")
    val options: Options? = null
)
