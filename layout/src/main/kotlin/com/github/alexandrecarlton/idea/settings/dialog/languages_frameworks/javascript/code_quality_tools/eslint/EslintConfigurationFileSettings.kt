package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.annotation.JsonValue
import java.io.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class EslintConfigurationFileSettings

@JsonTypeName("Automatic Search")
object EslintConfigurationFileSettingsAutomaticSearch : EslintConfigurationFileSettings()

@JsonTypeName("Configuration file")
data class EslintConfigurationFileSettingsConfigurationFile(
    @get:JsonValue
    val file: File? = null
) : EslintConfigurationFileSettings()
