package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import java.io.File

/**
 * We use a sealed class to represent a radio button.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class EslintSettings

@JsonTypeName("Disable ESLint")
object EslintSettingsDisableEslint : EslintSettings()

@JsonTypeName("Automatic ESLint configuration")
object EslintSettingsAutomaticEslintConfiguration : EslintSettings()

@JsonTypeName("Manual ESLint configuration")
data class ManualEslintConfigurationSettings (

    @JsonProperty("Node interpreter")
    val nodeInterpreter: File? = null,

    @JsonProperty("ESLint package")
    val eslintPackage: File? = null,

    @JsonProperty("Configuration file")
    val configurationFile: EslintConfigurationFileSettings? = null,

    @JsonProperty("Additional rules directory")
    val additionalRulesDirectory: File? = null,

    @JsonProperty("Extra eslint options")
    val extraEslintOptions: String? = null
) : EslintSettings()
