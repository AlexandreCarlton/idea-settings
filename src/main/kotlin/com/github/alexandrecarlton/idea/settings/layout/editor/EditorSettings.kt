package com.github.alexandrecarlton.idea.settings.layout.editor

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings

data class EditorSettings(

    val general: GeneralSettings? = null,

    val codeStyle: CodeStyleSettings? = null,

    val spelling: SpellingSettings? = null
)
