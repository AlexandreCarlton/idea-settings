package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.execution.BeforeRunTask
import org.jetbrains.idea.maven.tasks.MavenBeforeRunTask
import javax.inject.Inject

class RunMavenGoalSettingsApplier @Inject
constructor(private val beforeRunTasks: MutableList<BeforeRunTask<*>>) : SettingsApplier<RunMavenGoalSettings> {

    override fun apply(settings: RunMavenGoalSettings) {
        beforeRunTasks.add(MavenBeforeRunTask().apply {
            goal = settings.commandLine
            projectPath = settings.workingDirectory.resolve("pom.xml").absolutePath
        })
    }
}
