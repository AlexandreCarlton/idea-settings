package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.ImmutableCompilerSettings
import com.google.common.collect.ImmutableList
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerConfigurationImpl
import com.intellij.compiler.CompilerWorkspaceConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CompilerSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<CompilerSettings>
    private lateinit var compilerConfiguration: CompilerConfiguration
    private lateinit var compilerWorkspaceConfiguration: CompilerWorkspaceConfiguration

    @Before
    public override fun setUp() {
        compilerConfiguration = CompilerConfiguration.getInstance(project)
        compilerWorkspaceConfiguration = CompilerWorkspaceConfiguration.getInstance(project)
        settingsApplier = CompilerSettingsApplier(compilerConfiguration, compilerWorkspaceConfiguration)
    }

    @Test
    fun addRuntimeAssertionsForNotnullAnnotatedMethodsAndParametersApplied() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters(false)
                .build())
        assertThat(compilerConfiguration.isAddNotNullAssertions).isFalse()
    }

    @Test
    fun buildProcessHeapSizeApplied() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .buildProcessHeapSizeMbytes(1234)
                .build())
        assertThat(compilerConfiguration.getBuildProcessHeapSize(0)).isEqualTo(1234)
    }

    @Test
    fun compileIndependentModulesInParallel() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .compileIndependentModulesInParallel(true)
                .build())
        assertThat(compilerWorkspaceConfiguration.PARALLEL_COMPILATION).isTrue()
    }

    @Test
    fun rebuildModuleOnDependencyChange() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .rebuildModuleOnDependencyChange(false)
                .build())
        assertThat(compilerWorkspaceConfiguration.REBUILD_ON_DEPENDENCY_CHANGE).isFalse()
    }

    @Test
    fun sharedBuildProcessVmOptions() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .sharedBuildProcessVmOptions("-Xms1g")
                .build())
        assertThat(compilerConfiguration.buildProcessVMOptions).isEqualTo("-Xms1g")
    }

    @Test
    fun resourcePatternsIfNotSetAreDefaults() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .build())
        assertThat(compilerConfiguration).isInstanceOf(CompilerConfigurationImpl::class.java)
        val compilerConfigurationImpl = compilerConfiguration as CompilerConfigurationImpl
        assertThat(compilerConfigurationImpl.resourceFilePatterns).contains("!?*.java")
    }

    @Test
    fun resourcePatterns() {
        settingsApplier.apply(ImmutableCompilerSettings.builder()
                .resourcePatterns(ImmutableList.of("resource.properties"))
                .build())
        assertThat(compilerConfiguration).isInstanceOf(CompilerConfigurationImpl::class.java)
        val compilerConfigurationImpl = compilerConfiguration as CompilerConfigurationImpl
        assertThat(compilerConfigurationImpl.resourceFilePatterns).containsExactly("resource.properties")
    }
}
