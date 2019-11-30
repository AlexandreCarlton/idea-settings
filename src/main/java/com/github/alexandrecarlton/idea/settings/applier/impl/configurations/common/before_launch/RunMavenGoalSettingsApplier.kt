package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings
import com.intellij.execution.BeforeRunTask
import org.jetbrains.idea.maven.tasks.MavenBeforeRunTask
import javax.inject.Inject

class RunMavenGoalSettingsApplier @Inject
constructor(private val beforeRunTasks: MutableList<BeforeRunTask<*>>) : SettingsApplier<RunMavenGoalSettings> {

    override fun apply(settings: RunMavenGoalSettings) {
        val mavenBeforeRunTask = MavenBeforeRunTask()
        mavenBeforeRunTask.goal = settings.commandLine()
        mavenBeforeRunTask.projectPath = settings.workingDirectory().resolve("pom.xml").toString()
        beforeRunTasks.add(mavenBeforeRunTask)
    }
}
