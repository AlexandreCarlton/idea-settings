package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface BuildExecutionDeploymentModule {
    @Binds
    fun bindBuildExecutionDeploymentSettingsApplier(applier: BuildExecutionDeploymentSettingsApplier): SettingsApplier<BuildExecutionDeploymentSettings>
}
