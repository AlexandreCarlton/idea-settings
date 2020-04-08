package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinMinimumBlankLinesSettings(
    @JsonProperty("After class header")
    val afterClassHeader: Int? = null,

    @JsonProperty("Around 'when' branches with {}:")
    val aroundWhenBranchesWithBraces: Int? = null
)
