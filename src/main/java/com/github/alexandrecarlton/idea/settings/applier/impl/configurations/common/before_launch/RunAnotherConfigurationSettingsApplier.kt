package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings
import com.intellij.execution.BeforeRunTask
import com.intellij.execution.RunManager
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider
import com.intellij.openapi.diagnostic.Logger
import java.util.Objects
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

        val runnerAndConfigurationSettings = settings.type()
            .map { type -> runManager.findConfigurationByTypeAndName(configurationTypeMapper.mapRunConfigurationType(type), settings.name()) }
            .orElse(runManager.findConfigurationByName(settings.name()))
        if (runnerAndConfigurationSettings == null) {
            LOG.warn("Unable to find Run Configuration with name " + settings.name()
                + settings.type()
                .map { Objects.toString(it) }
                .map { " and type: $it" }
                .orElse("")
                + ".")
            return
        }

        val runConfigurableBeforeRunTask = runConfigurationBeforeRunProvider.createTask(runnerAndConfigurationSettings.configuration)
        runConfigurableBeforeRunTask?.also {
            it.setSettingsWithTarget(runnerAndConfigurationSettings, null)
            beforeRunTasks.add(it)
        }
    }

}
