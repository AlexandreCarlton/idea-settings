package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.fasterxml.jackson.annotation.JsonProperty

data class JavascriptCodeStyleSettings(
    @JsonProperty("Imports")
    val imports: JavascriptImportsSettings? = null
)
