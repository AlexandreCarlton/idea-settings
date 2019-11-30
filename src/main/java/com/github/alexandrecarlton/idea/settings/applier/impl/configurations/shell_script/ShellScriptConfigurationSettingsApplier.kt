package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.sh.run.ShConfigurationType
import com.intellij.sh.run.ShRunConfiguration
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

class ShellScriptConfigurationSettingsApplier @Inject
constructor(private val project: Project, private val runManager: RunManager) : SettingsApplier<ShellScriptConfigurationSettings> {

    override fun apply(settings: ShellScriptConfigurationSettings) {
        val shRunConfiguration = ShConfigurationType().createTemplateConfiguration(project) as ShRunConfiguration
        shRunConfiguration.name = settings.name()

        invokeSetMethod(shRunConfiguration, "setScriptPath", settings.scriptPath().toString())
        settings.scriptOptions()
            .ifPresent { scriptOptions -> invokeSetMethod(shRunConfiguration, "setScriptOptions", scriptOptions) }
        settings.interpreter()
            .flatMap { it.interpreterPath() }
            .map { it.toString() }
            .ifPresent { interpreterPath -> invokeSetMethod(shRunConfiguration, "setInterpreterPath", interpreterPath) }
        settings.interpreter()
            .flatMap { it.interpreterOptions() }
            .ifPresent { interpreterOptions -> invokeSetMethod(shRunConfiguration, "setInterpreterOptions", interpreterOptions) }

        val runnerAndConfigurationSettings = runManager.createConfiguration(shRunConfiguration, ShConfigurationType())
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun invokeSetMethod(shRunConfiguration: ShRunConfiguration, methodName: String, value: String) {
        try {
            val method = shRunConfiguration.javaClass.getDeclaredMethod(methodName, String::class.java)
            method.isAccessible = true
            method.invoke(shRunConfiguration, value)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Unable to invoke method $methodName with value $value.", e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException("Unable to invoke method $methodName with value $value.", e)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException("Unable to invoke method $methodName with value $value.", e)
        }
    }
}
