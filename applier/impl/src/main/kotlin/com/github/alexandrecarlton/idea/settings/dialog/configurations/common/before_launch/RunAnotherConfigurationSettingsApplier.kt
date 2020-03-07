package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.execution.BeforeRunTask
import com.intellij.execution.RunManager
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider
import com.intellij.openapi.diagnostic.Logger
import javax.inject.Inject

class RunAnotherConfigurationSettingsApplier @Inject
constructor(private val beforeRunTasks: MutableList<BeforeRunTask<*>>,
            private val configurationTypeMapper: ConfigurationTypeMapper,
            private val runConfigurationBeforeRunProvider: RunConfigurationBeforeRunProvider,
            private val runManager: RunManager
) : SettingsApplier<RunAnotherConfigurationSettings> {

    companion object {
        private val LOG = Logger.getInstance(RunAnotherConfigurationSettingsApplier::class.java)
    }

    override fun apply(settings: RunAnotherConfigurationSettings) {

        val runnerAndConfigurationSettings = settings.type
            ?.let { runManager.findConfigurationByTypeAndName(configurationTypeMapper.mapRunConfigurationType(it), settings.name) }
            ?: runManager.findConfigurationByName(settings.name)
        if (runnerAndConfigurationSettings == null) {
            LOG.warn("Unable to find Run Configuration with name ${settings.name} and type ${settings.type}")
            return
        }

        val runConfigurableBeforeRunTask = runConfigurationBeforeRunProvider.createTask(runnerAndConfigurationSettings.configuration)
        runConfigurableBeforeRunTask?.also {
            it.setSettingsWithTarget(runnerAndConfigurationSettings, null)
            beforeRunTasks.add(it)
        }
    }

}
