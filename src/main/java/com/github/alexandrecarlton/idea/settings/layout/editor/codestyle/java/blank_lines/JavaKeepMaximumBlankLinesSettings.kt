package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines

data class JavaKeepMaximumBlankLinesSettings(

    val inDeclarations: Int? = null,

    val inCode: Int? = null,

    val beforeRightBrace: Int? = null,

    val betweenHeaderAndPackage: Int? = null
)
