package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects

import com.fasterxml.jackson.annotation.JsonProperty

data class SqlDialectsSettings(
    @JsonProperty("Project SQL Dialect")
    val projectSqlDialect: SqlDialect? = null
)
