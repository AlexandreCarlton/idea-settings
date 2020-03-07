package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement

import com.fasterxml.jackson.annotation.JsonProperty

data class MatchingRule(

    @JsonProperty("Type")
    val type: MatchingRuleType? = null,

    // TODO: Check if this should default to null
    @JsonProperty("Modifier")
    val modifier: List<MatchingRuleModifier> = emptyList(),

    @JsonProperty("Name")
    val name: String? = null,

    @JsonProperty("Order")
    val order: MatchingRuleOrder? = null
)
