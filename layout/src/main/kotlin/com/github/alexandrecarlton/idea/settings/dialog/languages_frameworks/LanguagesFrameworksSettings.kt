package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.JavascriptSettings
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm.NodejsAndNpmSettings
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialectsSettings

data class LanguagesFrameworksSettings(

    @JsonProperty("JavaScript")
    val javascript: JavascriptSettings? = null,

    @JsonProperty("Node.js and NPM")
    val nodejsAndNpm: NodejsAndNpmSettings? = null,

    @JsonProperty("SQL Dialects")
    val sqlDialects: SqlDialectsSettings? = null
)
