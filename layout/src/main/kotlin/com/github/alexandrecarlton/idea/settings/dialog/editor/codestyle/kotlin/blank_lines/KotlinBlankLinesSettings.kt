package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinBlankLinesSettings(

    @JsonProperty("Keep Maximum Blank Lines")
    val keepMaximumBlankLines: KotlinKeepMaximumBlankLinesSettings? = null,

    @JsonProperty("Minimum Blank Lines")
    val minimumBlankLines: KotlinMinimumBlankLinesSettings? = null
)
