package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings

data class CodeStyleSettings(

    val java: JavaCodeStyleSettings? = null,

    val javascript: JavascriptCodeStyleSettings? = null
)
