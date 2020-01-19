package com.github.alexandrecarlton.idea.settings.layout.editor.inspections

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.JavaInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.JavascriptInspectionsSettings

data class InspectionsSettings(

    @JsonProperty("Java")
    val java: JavaInspectionsSettings? = null,

    @JsonProperty("JavaScript")
    val javascript: JavascriptInspectionsSettings? = null
)
