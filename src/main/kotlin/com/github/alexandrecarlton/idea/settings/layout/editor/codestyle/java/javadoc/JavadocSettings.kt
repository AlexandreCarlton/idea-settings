package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class JavadocSettings(

    // TODO: This isn't used.
    @JsonProperty("Enable JavaDoc Formatting")
    val enableJavadocFormatting: Boolean? = null,

    @JsonProperty("Alignment")
    val alignment: JavadocAlignmentSettings? = null,

    @JsonProperty("Blank lines")
    val blankLines: JavadocBlankLinesSettings? = null,

    @JsonProperty("Invalid tags")
    val invalidTags: JavadocInvalidTagsSettings? = null,

    @JsonProperty("Other")
    val other: JavadocOtherSettings? = null
)
