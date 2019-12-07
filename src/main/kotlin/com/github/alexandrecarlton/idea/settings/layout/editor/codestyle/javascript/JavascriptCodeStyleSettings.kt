package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript

import com.fasterxml.jackson.annotation.JsonProperty

data class JavascriptCodeStyleSettings(
    @JsonProperty("Imports")
    val imports: JavascriptImportsSettings? = null
)
