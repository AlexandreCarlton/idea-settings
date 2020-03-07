package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement.JavaArrangementSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines.JavaBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports.JavaImportsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc.JavadocSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings

data class JavaCodeStyleSettings(

    @JsonProperty("Arrangement")
    val arrangement: JavaArrangementSettings? = null,

    @JsonProperty("Blank Lines")
    val blankLines: JavaBlankLinesSettings? = null,

    @JsonProperty("Imports")
    val imports: JavaImportsSettings? = null,

    @JsonProperty("JavaDoc")
    val javadoc: JavadocSettings? = null,

    @JsonProperty("Wrapping and Braces")
    val wrappingAndBraces: JavaWrappingAndBracesSettings? = null
)
