package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.javascript.nodejs.util.NodePackageRef
import com.intellij.lang.javascript.linter.eslint.EslintConfiguration
import com.intellij.lang.javascript.linter.eslint.EslintState
import javax.inject.Inject

class EslintSettingsApplier @Inject
constructor(
    private val eslintConfiguration: EslintConfiguration
) : SettingsApplier<EslintSettings> {
    override fun apply(settings: EslintSettings) {
        when(settings) {
            EslintSettingsDisableEslint -> eslintConfiguration.isEnabled = false
            EslintSettingsAutomaticEslintConfiguration -> eslintConfiguration.isEnabled = true
            is ManualEslintConfigurationSettings -> apply(settings)
        }
    }

    private fun apply(settings: ManualEslintConfigurationSettings) {
        val eslintStateBuilder = EslintState.Builder(eslintConfiguration.extendedState.state)

        settings.eslintPackage?.let { eslintStateBuilder.setEslintPackage(NodePackageRef.create(it.toString())) }
        settings.configurationFile?.let {
            when(it) {
                EslintConfigurationFileSettingsAutomaticSearch -> eslintStateBuilder.setCustomConfigFileUsed(false)
                is EslintConfigurationFileSettingsConfigurationFile -> {
                    eslintStateBuilder.setCustomConfigFileUsed(true)
                    eslintStateBuilder.setCustomConfigFilePath(it.file.toString())
                }
            }
        }
        settings.additionalRulesDirectory?.let { eslintStateBuilder.setAdditionalRulesDirPath(it.toString()) }
        settings.extraEslintOptions?.let { eslintStateBuilder.setExtraOptions(it) }

        eslintConfiguration.setExtendedState(true, eslintStateBuilder.build())

    }
}
