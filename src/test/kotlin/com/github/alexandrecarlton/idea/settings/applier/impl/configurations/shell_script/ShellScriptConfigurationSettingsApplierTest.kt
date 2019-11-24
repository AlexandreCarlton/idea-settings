package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ImmutableInterpreterConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ImmutableShellScriptConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.sh.run.ShRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.lang.reflect.InvocationTargetException
import java.nio.file.Paths

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
        settingsApplier.apply(ImmutableShellScriptConfigurationSettings.builder()
                .name("Simple Shell Configuration")
                .scriptPath(Paths.get("/usr/bin/foo"))
                .build())

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
        settingsApplier.apply(ImmutableShellScriptConfigurationSettings.builder()
                .name("Full Shell Configuration")
                .scriptPath(Paths.get("/usr/bin/foo"))
                .scriptOptions("bar")
                .interpreter(ImmutableInterpreterConfigurationSettings.builder()
                        .interpreterPath(Paths.get("/bin/sh"))
                        .interpreterOptions("-e")
                        .build())
                .build())

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Full Shell Configuration")!!
        val shRunConfiguration = runnerAndConfigurationSettings.configuration as ShRunConfiguration
        assertThat(invokeGetMethod(shRunConfiguration, "getScriptPath")).isEqualTo("/usr/bin/foo")
        assertThat(invokeGetMethod(shRunConfiguration, "getScriptOptions")).isEqualTo("bar")
        assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterPath")).isEqualTo("/bin/sh")
        assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterOptions")).isEqualTo("-e")
    }

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
