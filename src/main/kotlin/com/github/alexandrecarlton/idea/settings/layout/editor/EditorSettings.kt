package com.github.alexandrecarlton.idea.settings.layout.editor

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.InspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings

data class EditorSettings(

    @JsonProperty("General")
    val general: GeneralSettings? = null,

    @JsonProperty("Code Style")
    val codeStyle: CodeStyleSettings? = null,

    @JsonProperty("Inspections")
    val inspections: InspectionsSettings? = null,

    @JsonProperty("Spelling")
    val spelling: SpellingSettings? = null
)
