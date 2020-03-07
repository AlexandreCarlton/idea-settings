package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class JavadocInvalidTagsSettings(

    @JsonProperty("Keep invalid tags")
    val keepInvalidTags: Boolean? = null,

    @JsonProperty("Keep empty @param tags")
    val keepEmptyParamTags: Boolean? = null,

    @JsonProperty("Keep empty @return tags")
    val keepEmptyReturnTags: Boolean? = null,

    @JsonProperty("Keep empty @throws tags")
    val keepEmptyThrowsTags: Boolean? = null
)
