package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaKeepMaximumBlankLinesSettings(

    @JsonProperty("In declarations")
    val inDeclarations: Int? = null,

    @JsonProperty("In code")
    val inCode: Int? = null,

    @JsonProperty("Before '}'")
    val beforeRightBrace: Int? = null,

    @JsonProperty("Between header and package")
    val betweenHeaderAndPackage: Int? = null
)
