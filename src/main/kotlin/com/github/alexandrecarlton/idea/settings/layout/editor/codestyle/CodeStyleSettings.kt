package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings

data class CodeStyleSettings(

    @JsonProperty("Java")
    val java: JavaCodeStyleSettings? = null,

    @JsonProperty("JavaScript")
    val javascript: JavascriptCodeStyleSettings? = null
)
