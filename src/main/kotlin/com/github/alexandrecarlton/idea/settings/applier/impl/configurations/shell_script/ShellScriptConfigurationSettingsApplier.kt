package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.ShellScriptConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.sh.run.ShConfigurationType
import com.intellij.sh.run.ShRunConfiguration
import javax.inject.Inject

class ShellScriptConfigurationSettingsApplier @Inject
constructor(private val project: Project, private val runManager: RunManager) : SettingsApplier<ShellScriptConfigurationSettings> {

    private val LOG = Logger.getInstance(ShellScriptConfigurationSettingsApplier::class.java)

    override fun apply(settings: ShellScriptConfigurationSettings) {
        val shRunConfiguration = ShConfigurationType().createTemplateConfiguration(project) as ShRunConfiguration
        shRunConfiguration.name = settings.name

        invokeSetMethod(shRunConfiguration, "setScriptPath", settings.scriptPath.toString())
        settings.scriptOptions?.let { invokeSetMethod(shRunConfiguration, "setScriptOptions", it) }
        settings.interpreter?.interpreterPath?.toString()?.let { invokeSetMethod(shRunConfiguration, "setInterpreterPath", it) }
        settings.interpreter?.interpreterOptions?.let { invokeSetMethod(shRunConfiguration, "setInterpreterOptions", it) }

        val runnerAndConfigurationSettings = runManager.createConfiguration(shRunConfiguration, ShConfigurationType())
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun invokeSetMethod(shRunConfiguration: ShRunConfiguration, methodName: String, value: String) {
        try {
            val method = shRunConfiguration.javaClass.getDeclaredMethod(methodName, String::class.java)
            method.isAccessible = true
            method.invoke(shRunConfiguration, value)
        } catch (e: Exception) {
             LOG.warn("Unable to invoke method $methodName with value $value.", e)
        }
    }
}
