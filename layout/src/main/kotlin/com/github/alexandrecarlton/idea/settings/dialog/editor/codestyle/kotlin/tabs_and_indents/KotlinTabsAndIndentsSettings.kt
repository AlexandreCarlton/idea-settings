package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinTabsAndIndentsSettings(
    @JsonProperty("Continuation indent")
    val continuationIndent: Int? = null
)
