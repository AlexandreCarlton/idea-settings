package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.fasterxml.jackson.annotation.JsonProperty

data class JavascriptImportsSettings(
    @JsonProperty("Use paths relative to the project, resource or sources roots")
    val usePathsRelativeToTheProjectResourceOrSourcesRoots: Boolean? = null
)
