package com.github.alexandrecarlton.idea.settings.layout.editor.inspections

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.JavaInspectionsSettings

data class InspectionsSettings(

    @JsonProperty("Java")
    val java: JavaInspectionsSettings? = null
)
