package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Each inspection can be enabled across all scopes,
 * and for each scope can be configured to have a different severity,
 * and have a different options configuration.
 * Note that these options differ by inspection, hence why we parameterise on it.
 */
data class BaseInspectionSettings<Options>(

    @JsonProperty("Enabled")
    val enabled: Boolean? = null,

    @JsonProperty("Severity by Scope")
    val severityByScope: List<ScopedSeverity<Options>>? = null
)
