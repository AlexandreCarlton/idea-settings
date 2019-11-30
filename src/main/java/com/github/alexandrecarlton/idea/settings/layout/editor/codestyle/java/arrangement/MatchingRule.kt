package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement

data class MatchingRule(

    val type: MatchingRuleType? = null,

    // TODO: Check if this should default to null
    val modifier: List<MatchingRuleModifier> = emptyList(),

    val name: String? = null,

    val order: MatchingRuleOrder?
)
