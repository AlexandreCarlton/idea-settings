package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class JavadocBlankLinesSettings(

    @JsonProperty("After description")
    val afterDescription: Boolean? = null,

    @JsonProperty("After parameter descriptions")
    val afterParameterDescriptions: Boolean? = null,

    @JsonProperty("After return tag")
    val afterReturnTag: Boolean? = null
)
