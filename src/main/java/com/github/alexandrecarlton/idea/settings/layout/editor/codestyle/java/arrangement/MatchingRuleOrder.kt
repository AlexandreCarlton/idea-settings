package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement

import com.fasterxml.jackson.annotation.JsonProperty

enum class MatchingRuleOrder {

    @JsonProperty("keep order")
    KEEP_ORDER,

    @JsonProperty("order by name")
    ORDER_BY_NAME
}
