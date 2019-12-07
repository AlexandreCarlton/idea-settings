package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaBlankLinesSettings(

    @JsonProperty("Keep Maximum Blank Lines")
    val keepMaximumBlankLines: JavaKeepMaximumBlankLinesSettings? = null,

    @JsonProperty("Minimum Blank Lines")
    val minimumBlankLines: JavaMinimumBlankLinesSettings? = null
)
