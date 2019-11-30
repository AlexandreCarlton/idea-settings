package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings

data class JavaCodeStyleSettings(

    val arrangement: JavaArrangementSettings? = null,

    val blankLines: JavaBlankLinesSettings? = null,

    val imports: JavaImportsSettings? = null,

    val javadoc: JavadocSettings? = null,

    val wrappingAndBraces: JavaWrappingAndBracesSettings? = null
)
