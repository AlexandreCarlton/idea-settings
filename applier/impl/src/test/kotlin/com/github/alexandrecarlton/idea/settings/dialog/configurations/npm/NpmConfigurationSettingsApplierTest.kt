package com.github.alexandrecarlton.idea.settings.dialog.configurations.npm

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.NpmConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment.EnvironmentVariable
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.lang.javascript.buildTools.npm.rc.NpmCommand
import com.intellij.lang.javascript.buildTools.npm.rc.NpmRunConfiguration
import com.intellij.lang.javascript.buildTools.npm.rc.NpmRunSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File
import java.util.AbstractMap.SimpleEntry

class NpmConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var applier: SettingsApplier<NpmConfigurationSettings>

    @Before
    public override fun setUp() {
        applier = NpmConfigurationSettingsApplier(project, platform.runManager)
    }

    @Test
    fun packageJsonApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with package.json",
            packageJson = File("package.json")))
        assertThat(getNpmRunSettings("Npm with package.json").packageJsonSystemIndependentPath).isEqualTo("package.json")
    }

    @Test
    fun commandApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with command",
            command = NpmConfigurationCommand.START))
        assertThat(getNpmRunSettings("Npm with command").command).isEqualTo(NpmCommand.START)
    }

    @Test
    fun scriptApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with script",
            command = NpmConfigurationCommand.RUN,
            scripts = "my-script"))
        assertThat(getNpmRunSettings("Npm with script").command).isEqualTo(NpmCommand.RUN_SCRIPT)
        assertThat(getNpmRunSettings("Npm with script").scriptNames).containsExactly("my-script")
    }

    @Test
    fun scriptWithArgumentsApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with script and arguments",
            command = NpmConfigurationCommand.RUN,
            scripts = "my-script",
            arguments = "argument1 argument2"))
        assertThat(getNpmRunSettings("Npm with script and arguments").command).isEqualTo(NpmCommand.RUN_SCRIPT)
        assertThat(getNpmRunSettings("Npm with script and arguments").scriptNames).containsExactly("my-script")
        assertThat(getNpmRunSettings("Npm with script and arguments").arguments).isEqualTo("argument1 argument2")
    }

    @Test
    fun nodeInterpreterApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with node interpreter",
            nodeInterpreter = File("path/to/node")))
        assertThat(getNpmRunSettings("Npm with node interpreter").interpreterRef.referenceName).isEqualTo("path/to/node")
    }

    @Test
    fun nodeOptionsApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with node options",
            nodeOptions = "--options"))
        assertThat(getNpmRunSettings("Npm with node options").nodeOptions).isEqualTo("--options")
    }

    @Test
    fun packageManagerApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with package manager",
            packageManager = File("path/to/npm")))
        assertThat(getNpmRunSettings("Npm with package manager").packageManagerPackageRef.referenceName).isEqualTo("path/to/npm")
    }

    @Test
    fun environmentApplied() {
        applier.apply(NpmConfigurationSettings(
            name = "Npm with environment",
            environment = listOf(
                EnvironmentVariable(name = "a", value = "1"),
                EnvironmentVariable(name = "b", value = "2"))))
        assertThat(getNpmRunSettings("Npm with environment").envData.envs).containsExactly(SimpleEntry("a", "1"), SimpleEntry("b", "2"))
    }

    private fun getNpmRunSettings(name: String): NpmRunSettings {
        val runnerAndConfigurationSettings = platform.runManager.findConfigurationByName(name)
        assertThat(runnerAndConfigurationSettings).isNotNull()
        val npmRunConfiguration = runnerAndConfigurationSettings!!.configuration as NpmRunConfiguration
        return npmRunConfiguration.runSettings
    }
}
