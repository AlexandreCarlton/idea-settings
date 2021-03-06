package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.compiler.options.CompileStepBeforeRun.MakeBeforeRunTask
import com.intellij.execution.BeforeRunTask
import javax.inject.Inject

class BuildConfigurationSettingsApplier @Inject
constructor(private val beforeRunTasks: MutableList<BeforeRunTask<*>>) : SettingsApplier<BuildConfigurationSettings> {

    override fun apply(settings: BuildConfigurationSettings) {
        val makeBeforeRunTask = MakeBeforeRunTask()
        beforeRunTasks.add(makeBeforeRunTask)
    }
}
