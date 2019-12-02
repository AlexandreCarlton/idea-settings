package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

data class JavaKeepWhenReformattingSettings(

    val lineBreaks: Boolean? = null,

    val commentAtFirstColumn: Boolean? = null,

    val controlStatementInOneLine: Boolean? = null,

    val multipleExpressionsInOneLine: Boolean? = null,

    val simpleBlocksInOneLine: Boolean? = null,

    val simpleMethodsInOneLine: Boolean? = null,

    val simpleLambdasInOneLine: Boolean? = null,

    val simpleClassesInOneLine: Boolean? = null
)
