package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines.KotlinBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation.KotlinCodeGenerationSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports.KotlinImportsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents.KotlinTabsAndIndentsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces.KotlinWrappingAndBracesSettings

data class KotlinCodeStyleSettings(

    @JsonProperty("Set from")
    val setFrom: KotlinDefaultCodeStyle? = null,

    @JsonProperty("Blank Lines")
    val blankLines: KotlinBlankLinesSettings? = null,

    @JsonProperty("Code Generation")
    val codeGeneration: KotlinCodeGenerationSettings? = null,

    @JsonProperty("Imports")
    val imports: KotlinImportsSettings? = null,

    @JsonProperty("Tabs and Indents")
    val tabsAndIndents: KotlinTabsAndIndentsSettings? = null,

    @JsonProperty("Wrapping and Braces")
    val wrappingAndBraces: KotlinWrappingAndBracesSettings? = null
)
