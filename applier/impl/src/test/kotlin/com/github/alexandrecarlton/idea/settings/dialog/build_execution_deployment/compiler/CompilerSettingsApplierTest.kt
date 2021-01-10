package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.compiler.CompilerConfigurationImpl
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CompilerSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<CompilerSettings>
    private val nullableNotNullConfigurationSettingsApplier = mockk<SettingsApplier<NullableNotNullConfigurationSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        settingsApplier = CompilerSettingsApplier(platform.compilerConfiguration, platform.compilerWorkspaceConfiguration, nullableNotNullConfigurationSettingsApplier)
    }

    @Test
    fun addRuntimeAssertionsForNotnullAnnotatedMethodsAndParametersApplied() {
        settingsApplier.apply(CompilerSettings(addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters = false))
        assertThat(platform.compilerConfiguration.isAddNotNullAssertions).isFalse()
    }

    @Test
    fun buildProcessHeapSizeApplied() {
        settingsApplier.apply(CompilerSettings(buildProcessHeapSizeMbytes = 1234))
        assertThat(platform.compilerConfiguration.getBuildProcessHeapSize(0)).isEqualTo(1234)
    }

    @Test
    fun compileIndependentModulesInParallel() {
        settingsApplier.apply(CompilerSettings(compileIndependentModulesInParallel = true))
        assertThat(platform.compilerConfiguration.isParallelCompilationEnabled).isTrue()
    }

    @Test
    fun rebuildModuleOnDependencyChange() {
        settingsApplier.apply(CompilerSettings(rebuildModuleOnDependencyChange = false))
        assertThat(platform.compilerWorkspaceConfiguration.REBUILD_ON_DEPENDENCY_CHANGE).isFalse()
    }

    @Test
    fun sharedBuildProcessVmOptions() {
        settingsApplier.apply(CompilerSettings(sharedBuildProcessVmOptions = "-Xms1g"))
        assertThat(platform.compilerConfiguration.buildProcessVMOptions).isEqualTo("-Xms1g")
    }

    @Test
    fun resourcePatternsIfNotSetAreDefaults() {
        settingsApplier.apply(CompilerSettings())
        assertThat(platform.compilerConfiguration).isInstanceOf(CompilerConfigurationImpl::class.java)
        val compilerConfigurationImpl = platform.compilerConfiguration as CompilerConfigurationImpl
        assertThat(compilerConfigurationImpl.resourceFilePatterns).contains("!?*.java")
    }

    @Test
    fun resourcePatterns() {
        settingsApplier.apply(CompilerSettings(resourcePatterns = listOf("resource.properties")))
        assertThat(platform.compilerConfiguration).isInstanceOf(CompilerConfigurationImpl::class.java)
        val compilerConfigurationImpl = platform.compilerConfiguration as CompilerConfigurationImpl
        assertThat(compilerConfigurationImpl.resourceFilePatterns).containsExactly("resource.properties")
    }
}
