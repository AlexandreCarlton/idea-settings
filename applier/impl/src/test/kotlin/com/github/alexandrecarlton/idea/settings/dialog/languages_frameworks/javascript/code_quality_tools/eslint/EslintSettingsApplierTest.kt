package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.io.File

// Ignored as we seem to be getting the below error...
@Ignore("Can't find tools for \"Eslint\" in the profile ...")
class EslintSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<EslintSettings>

    @Before
    public override fun setUp() {
        settingsApplier = EslintSettingsApplier(platform.eslintConfiguration)
    }

    @Test
    fun disableEslintApplied() {
        settingsApplier.apply(EslintSettingsDisableEslint)
        assertThat(platform.eslintConfiguration.isEnabled).isFalse()
    }

    @Test
    fun automaticEslintConfigurationApplied() {
        settingsApplier.apply(EslintSettingsAutomaticEslintConfiguration)
        assertThat(platform.eslintConfiguration.isEnabled).isTrue()
    }

    @Test
    fun manualEslintConfigurationWithEslintPackageApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            eslintPackage = File("/usr/lib/node_modules/eslint")))
        assertThat(platform.eslintConfiguration.extendedState.state.nodePackageRef.referenceName).isEqualTo("/usr/bin/node")
    }

    @Test
    fun manualEslintConfigurationWithAutomaticConfigurationFileApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            configurationFile = EslintConfigurationFileSettingsAutomaticSearch))
        assertThat(platform.eslintConfiguration.extendedState.state.isCustomConfigFileUsed).isFalse()
    }

    @Test
    fun manualEslintConfigurationWithConfigurationFileApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            configurationFile = EslintConfigurationFileSettingsConfigurationFile(File(".eslint-foo.js"))))
        assertThat(platform.eslintConfiguration.extendedState.state.isCustomConfigFileUsed).isTrue()
        assertThat(platform.eslintConfiguration.extendedState.state.customConfigFilePath).isEqualTo(".eslint-foo.js")
    }

    @Test
    fun additionalRulesDirectoryApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            additionalRulesDirectory = File("rules")))
        assertThat(platform.eslintConfiguration.extendedState.state.additionalRulesDirPath).isEqualTo("rules")
    }

    @Test
    fun extraEslintOptionsApplied() {
        settingsApplier.apply(ManualEslintConfigurationSettings(
            extraEslintOptions = "--extra-opts"))
        assertThat(platform.eslintConfiguration.extendedState.state.extraOptions).isEqualTo("--extra-opts")
    }
}
