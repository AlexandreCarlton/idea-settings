package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings
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
        externalDependenciesManager.allDependencies = settings.requiredPlugins()
            .map { required ->
                DependencyOnPlugin(
                    required.plugin(),
                    required.minimumVersion().orElse(null),
                    required.maximumVersion().orElse(null))
            }

        settings.buildTools().ifPresent { buildToolsSettingsApplier.apply(it) }
        settings.compiler().ifPresent { compilerSettingsApplier.apply(it) }
    }
}
