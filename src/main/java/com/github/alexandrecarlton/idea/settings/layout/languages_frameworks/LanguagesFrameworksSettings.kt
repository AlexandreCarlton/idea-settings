package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks

import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings

data class LanguagesFrameworksSettings(

    val javascript: JavascriptSettings? = null,

    val sqlDialects: SqlDialectsSettings? = null
)
