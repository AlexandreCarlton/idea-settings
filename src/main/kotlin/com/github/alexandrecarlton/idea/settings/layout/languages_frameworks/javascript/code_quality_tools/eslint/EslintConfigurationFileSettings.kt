package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import java.io.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class EslintConfigurationFileSettings

@JsonTypeName("Automatic Search")
object EslintConfigurationFileSettingsAutomaticSearch : EslintConfigurationFileSettings()

/**
 * Inline classes aren't supported as being:
 * - sealed (by Kotlin)
 * - unwrapped (by Jackson)
 * As such, we have an extra 'file' attribute we need to set.
 */
@JsonTypeName("Configuration file")
data class EslintConfigurationFileSettingsConfigurationFile(
    @JsonProperty("File")
    val file: File? = null
) : EslintConfigurationFileSettings()
