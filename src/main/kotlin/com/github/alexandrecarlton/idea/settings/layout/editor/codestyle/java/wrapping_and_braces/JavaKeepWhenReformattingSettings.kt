package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaKeepWhenReformattingSettings(

    @JsonProperty("Force braces")
    val lineBreaks: Boolean? = null,

    @JsonProperty("Comment at first column")
    val commentAtFirstColumn: Boolean? = null,

    @JsonProperty("Control statement in one line")
    val controlStatementInOneLine: Boolean? = null,

    @JsonProperty("Multiple expressions in one line")
    val multipleExpressionsInOneLine: Boolean? = null,

    @JsonProperty("Simple blocks in one line")
    val simpleBlocksInOneLine: Boolean? = null,

    @JsonProperty("Simple methods in one line")
    val simpleMethodsInOneLine: Boolean? = null,

    @JsonProperty("Simple lambdas in one line")
    val simpleLambdasInOneLine: Boolean? = null,

    @JsonProperty("Simple classes in one line")
    val simpleClassesInOneLine: Boolean? = null
)
