package com.github.alexandrecarlton.idea.settings.configuration

import com.intellij.execution.BeforeRunTask
import com.intellij.execution.RunManager
import com.intellij.execution.RunnerAndConfigurationSettings
import com.intellij.execution.configurations.RunConfiguration
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object ConfigurationModule {

    @Provides
    fun provideRunnerAndConfigurationSettings(@Named("configuration") name: String, runManager: RunManager) =
        runManager.findConfigurationByName(name)!!

    // #getBeforeRunTasks returns the underlying list, not just a copy.
    // If Jetbrains makes the method more robust, we can bind an empty ArrayList<BeforeRunTask<?>>() instead.
    @Provides
    fun provideBeforeRunTasks(runConfiguration: RunConfiguration): List<BeforeRunTask<*>> =
        runConfiguration.beforeRunTasks

    @Provides
    fun provideRunConfiguration(runnerAndConfigurationSettings: RunnerAndConfigurationSettings) =
        runnerAndConfigurationSettings.configuration
}
