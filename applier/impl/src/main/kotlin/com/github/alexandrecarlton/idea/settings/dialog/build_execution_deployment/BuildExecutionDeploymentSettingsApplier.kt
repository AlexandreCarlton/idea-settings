package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.CompilerSettings
import com.intellij.externalDependencies.DependencyOnPlugin
import com.intellij.externalDependencies.ExternalDependenciesManager
import javax.inject.Inject

class BuildExecutionDeploymentSettingsApplier @Inject
constructor(
    private val externalDependenciesManager: ExternalDependenciesManager,
    private val buildToolsSettingsApplier: SettingsApplier<BuildToolsSettings>,
    private val compilerSettingsApplier: SettingsApplier<CompilerSettings>
) : SettingsApplier<BuildExecutionDeploymentSettings> {

    override fun apply(settings: BuildExecutionDeploymentSettings) {
        settings.requiredPlugins
            ?.map { required -> DependencyOnPlugin(required.plugin, required.minimumVersion, required.maximumVersion) }
            ?.let { externalDependenciesManager.allDependencies = it }

        settings.buildTools?.let(buildToolsSettingsApplier::apply)
        settings.compiler?.let(compilerSettingsApplier::apply)
    }
}
