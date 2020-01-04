package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NullableNotNullConfigurationSettings
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerConfigurationImpl
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.openapi.diagnostic.Logger
import javax.inject.Inject

class CompilerSettingsApplier @Inject
constructor(
    private val compilerConfiguration: CompilerConfiguration,
    private val compilerWorkspaceConfiguration: CompilerWorkspaceConfiguration,
    private val nullableNotNullConfigurationSettingsApplier: SettingsApplier<NullableNotNullConfigurationSettings>
) : SettingsApplier<CompilerSettings> {

    companion object {
        private val LOG = Logger.getInstance(CompilerSettingsApplier::class.java)
    }

    override fun apply(settings: CompilerSettings) {
        settings.addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters?.let { compilerConfiguration.isAddNotNullAssertions = it }
        settings.nullableNotNullConfiguration?.let(nullableNotNullConfigurationSettingsApplier::apply)
        settings.buildProcessHeapSizeMbytes?.let { compilerConfiguration.setBuildProcessHeapSize(it) }
        settings.compileIndependentModulesInParallel?.let { compilerWorkspaceConfiguration.PARALLEL_COMPILATION = it }
        settings.rebuildModuleOnDependencyChange?.let { compilerWorkspaceConfiguration.REBUILD_ON_DEPENDENCY_CHANGE = it }
        settings.sharedBuildProcessVmOptions?.let { compilerConfiguration.buildProcessVMOptions = it }

        if (compilerConfiguration is CompilerConfigurationImpl) {
            settings.resourcePatterns?.let { patterns ->
                compilerConfiguration.removeResourceFilePatterns()
                patterns.forEach { compilerConfiguration.addResourceFilePattern(it) }
            }
        } else {
            LOG.warn("Unable to apply compiler resource pattern; injected CompilerConfiguration is not CompilerConfigurationImpl")
        }
    }
}
