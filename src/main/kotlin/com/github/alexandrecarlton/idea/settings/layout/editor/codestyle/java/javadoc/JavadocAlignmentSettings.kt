package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class JavadocAlignmentSettings(

    @JsonProperty("Align parameter descriptions")
    val alignParameterDescriptions: Boolean? = null,

    @JsonProperty("Align thrown exception descriptions")
    val alignThrownExceptionDescriptions: Boolean? = null
)
