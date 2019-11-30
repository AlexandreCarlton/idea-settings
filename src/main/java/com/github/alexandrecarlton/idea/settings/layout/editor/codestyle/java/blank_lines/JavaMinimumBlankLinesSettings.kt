package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines

data class JavaMinimumBlankLinesSettings(

    val beforePackageStatement: Int? = null,

    val afterPackageStatement: Int? = null,

    val beforeImports: Int? = null,

    val afterImports: Int? = null,

    val aroundClass: Int? = null,

    val afterClassHeader: Int? = null,

    val beforeClassEnd: Int? = null,

    val afterAnonymousClassHeader: Int? = null,

    val aroundFieldInInterface: Int? = null,

    val aroundField: Int? = null,

    val aroundMethodInInterface: Int? = null,

    val aroundMethod: Int? = null,

    val beforeMethodBody: Int? = null,

    val aroundInitializer: Int? = null
)
