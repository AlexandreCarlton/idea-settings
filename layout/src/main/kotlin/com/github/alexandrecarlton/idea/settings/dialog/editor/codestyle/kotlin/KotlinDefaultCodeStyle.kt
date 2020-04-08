package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin

import com.fasterxml.jackson.annotation.JsonProperty

enum class KotlinDefaultCodeStyle {

    @JsonProperty("Kotlin style guide")
    KOTLIN_STYLE_GUIDE,

    @JsonProperty("Kotlin obsolete IntelliJ IDEA codestyle")
    KOTLIN_OBSOLETE_INTELLIJ_IDEA_CODESTYLE
}
