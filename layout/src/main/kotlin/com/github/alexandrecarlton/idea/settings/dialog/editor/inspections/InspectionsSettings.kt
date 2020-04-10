package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.JavaInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.JavascriptInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.KotlinInspectionsSettings

data class InspectionsSettings(

    @JsonProperty("Java")
    val java: JavaInspectionsSettings? = null,

    @JsonProperty("JavaScript")
    val javascript: JavascriptInspectionsSettings? = null,

    @JsonProperty("Kotlin")
    val kotlin: KotlinInspectionsSettings? = null
)
