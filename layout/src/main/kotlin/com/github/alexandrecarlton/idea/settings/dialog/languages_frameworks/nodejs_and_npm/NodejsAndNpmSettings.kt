package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class NodejsAndNpmSettings(
    @JsonProperty("Node interpreter")
    val nodeInterpreter: File? = null,

    @JsonProperty("Package manager")
    val packageManager: File? = null
)
