package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc

data class JavadocSettings(

    val enableJavadocFormatting: Boolean? = null,

    val alignment: JavadocAlignmentSettings? = null,

    val blankLines: JavadocBlankLinesSettings? = null,

    val invalidTags: JavadocInvalidTagsSettings? = null,

    val other: JavadocOtherSettings? = null
)
