package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript.JavascriptCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.KotlinCodeStyleSettings

data class CodeStyleSettings(

    @JsonProperty("Java")
    val java: JavaCodeStyleSettings? = null,

    @JsonProperty("JavaScript")
    val javascript: JavascriptCodeStyleSettings? = null,

    @JsonProperty("Kotlin")
    val kotlin: KotlinCodeStyleSettings? = null
)
