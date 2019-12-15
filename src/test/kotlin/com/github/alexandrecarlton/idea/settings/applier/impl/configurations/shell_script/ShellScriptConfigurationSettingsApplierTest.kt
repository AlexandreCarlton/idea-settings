package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.ShellScriptConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.InterpreterConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.sh.run.ShRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File
import java.lang.reflect.InvocationTargetException

class ShellScriptConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<ShellScriptConfigurationSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        runManager = RunManager.getInstance(project)
        settingsApplier = ShellScriptConfigurationSettingsApplier(project, runManager)
    }

    @Test
    fun simpleShellConfiguration() {
        settingsApplier.apply(ShellScriptConfigurationSettings(
            name = "Simple Shell Configuration",
            scriptPath = File("/usr/bin/foo")))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Simple Shell Configuration")
        assertThat(runnerAndConfigurationSettings).isNotNull()
        val runConfiguration = runnerAndConfigurationSettings!!.configuration
        assertThat(runConfiguration).isNotNull()
        assertThat(runConfiguration).isInstanceOf(ShRunConfiguration::class.java)
        val shRunConfiguration = runConfiguration as ShRunConfiguration
        assertThat(invokeGetMethod(shRunConfiguration, "getScriptPath")).isEqualTo("/usr/bin/foo")
    }

    @Test
    fun fullShellConfiguration() {
        settingsApplier.apply(ShellScriptConfigurationSettings(
                name = "Full Shell Configuration",
                scriptPath = File("/usr/bin/foo"),
                scriptOptions = "bar",
                interpreter = InterpreterConfigurationSettings(
                    interpreterPath = File("/bin/sh"),
                    interpreterOptions ="-e")))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Full Shell Configuration")!!
        val shRunConfiguration = runnerAndConfigurationSettings.configuration as ShRunConfiguration
        assertThat(invokeGetMethod(shRunConfiguration, "getScriptPath")).isEqualTo("/usr/bin/foo")
        assertThat(invokeGetMethod(shRunConfiguration, "getScriptOptions")).isEqualTo("bar")
        assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterPath")).isEqualTo("/bin/sh")
        assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterOptions")).isEqualTo("-e")
    }

    // TODO: Look into Kotlin method of reflection
    private fun invokeGetMethod(shRunConfiguration: ShRunConfiguration, methodName: String): String {
        try {
            val method = shRunConfiguration.javaClass.getDeclaredMethod(methodName)
            method.isAccessible = true
            return method.invoke(shRunConfiguration) as String
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Unable to invoke method $methodName.", e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException("Unable to invoke method $methodName.", e)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException("Unable to invoke method $methodName.", e)
        }
    }
}
