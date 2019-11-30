package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerConfigurationImpl
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.openapi.diagnostic.Logger
import javax.inject.Inject

class CompilerSettingsApplier @Inject
constructor(
    private val compilerConfiguration: CompilerConfiguration,
    private val compilerWorkspaceConfiguration: CompilerWorkspaceConfiguration
) : SettingsApplier<CompilerSettings> {

    private val LOG = Logger.getInstance(CompilerSettingsApplier::class.java)

    override fun apply(settings: CompilerSettings) {
        settings.addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters()
            .ifPresent { compilerConfiguration.isAddNotNullAssertions = it }
        settings.buildProcessHeapSizeMbytes()
            .ifPresent { compilerConfiguration.setBuildProcessHeapSize(it) }
        settings.compileIndependentModulesInParallel()
            .ifPresent { compilerWorkspaceConfiguration.PARALLEL_COMPILATION = it }
        settings.rebuildModuleOnDependencyChange()
            .ifPresent { compilerWorkspaceConfiguration.REBUILD_ON_DEPENDENCY_CHANGE = it }
        settings.sharedBuildProcessVmOptions()
            .ifPresent { compilerConfiguration.buildProcessVMOptions = it }

        if (compilerConfiguration is CompilerConfigurationImpl) {
            settings.resourcePatterns().ifPresent { patterns ->
                compilerConfiguration.removeResourceFilePatterns()
                patterns.forEach { compilerConfiguration.addResourceFilePattern(it) }
            }
        } else {
            LOG.warn("Unable to apply compiler resource pattern; injected CompilerConfiguration is not CompilerConfigurationImpl")
        }
    }
}
