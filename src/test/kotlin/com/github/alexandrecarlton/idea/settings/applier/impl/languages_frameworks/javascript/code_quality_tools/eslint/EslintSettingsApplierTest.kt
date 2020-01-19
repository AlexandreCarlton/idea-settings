package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.code_quality_tools.eslint

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintConfigurationFileSettingsAutomaticSearch
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintConfigurationFileSettingsConfigurationFile
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettingsAutomaticEslintConfiguration
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettingsDisableEslint
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.ManualEslintConfigurationSettings
import com.intellij.lang.javascript.linter.eslint.EslintConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.io.File

// Ignored as we seem to be getting the below error...
@Ignore("Can't find tools for \"Eslint\" in the profile ...")
class EslintSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var eslintConfiguration: EslintConfiguration
    private lateinit var settingsApplier: SettingsApplier<EslintSettings>

    @Before
    public override fun setUp() {
        eslintConfiguration = EslintConfiguration.getInstance(project)
        settingsApplier = EslintSettingsApplier(eslintConfiguration)
    }

    @Test
    fun disableEslintApplied() {
        settingsApplier.apply(EslintSettingsDisableEslint)
        assertThat(eslintConfiguration.isEnabled).isFalse()
    }

    @Test
    fun automaticEslintConfigurationApplied() {
        settingsApplier.apply(EslintSettingsAutomaticEslintConfiguration)
        assertThat(eslintConfiguration.isEnabled).isTrue()
    }

    @Test
    fun manualEslintConfigurationWithNodeInterpreterApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            nodeInterpreter = File("/usr/bin/node")))
        assertThat(eslintConfiguration.extendedState.state.interpreterRef.referenceName).isEqualTo("/usr/bin/node")
    }

    @Test
    fun manualEslintConfigurationWithEslintPackageApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            eslintPackage = File("/usr/lib/node_modules/eslint")))
        assertThat(eslintConfiguration.extendedState.state.nodePackageRef.referenceName).isEqualTo("/usr/bin/node")
    }

    @Test
    fun manualEslintConfigurationWithAutomaticConfigurationFileApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            configurationFile = EslintConfigurationFileSettingsAutomaticSearch))
        assertThat(eslintConfiguration.extendedState.state.isCustomConfigFileUsed).isFalse()
    }

    @Test
    fun manualEslintConfigurationWithConfigurationFileApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            configurationFile = EslintConfigurationFileSettingsConfigurationFile(File(".eslint-foo.js"))))
        assertThat(eslintConfiguration.extendedState.state.isCustomConfigFileUsed).isTrue()
        assertThat(eslintConfiguration.extendedState.state.customConfigFilePath).isEqualTo(".eslint-foo.js")
    }

    @Test
    fun additionalRulesDirectoryApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            additionalRulesDirectory = File("rules")))
        assertThat(eslintConfiguration.extendedState.state.additionalRulesDirPath).isEqualTo("rules")
    }

    @Test
    fun extraEslintOptionsApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            extraEslintOptions = "--extra-opts"))
        assertThat(eslintConfiguration.extendedState.state.extraOptions).isEqualTo("--extra-opts")
    }
}
