package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaArrangementSettings(
    @JsonProperty("Matching rules")
    val matchingRules: List<MatchingRule>? = null
)
