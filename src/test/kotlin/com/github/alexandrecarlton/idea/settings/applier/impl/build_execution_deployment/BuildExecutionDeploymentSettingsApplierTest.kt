package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.RequiredPlugin
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings
import com.intellij.externalDependencies.DependencyOnPlugin
import com.intellij.externalDependencies.ExternalDependenciesManager
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class BuildExecutionDeploymentSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<BuildExecutionDeploymentSettings>
    private lateinit var externalDependenciesManager: ExternalDependenciesManager
    private val buildToolsSettingsApplier = mockk<SettingsApplier<BuildToolsSettings>>(relaxUnitFun = true)
    private val compilerSettingsApplier = mockk<SettingsApplier<CompilerSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        externalDependenciesManager = ExternalDependenciesManager.getInstance(project)
        settingsApplier = BuildExecutionDeploymentSettingsApplier(externalDependenciesManager, buildToolsSettingsApplier, compilerSettingsApplier)
    }

    @After
    public override fun tearDown() {
        externalDependenciesManager.allDependencies = emptyList()
    }

    @Test
    fun requiredPluginsApplied() {
        settingsApplier.apply(BuildExecutionDeploymentSettings(requiredPlugins = listOf(RequiredPlugin(plugin = "CheckStyle-IDEA"))))
        assertThat(externalDependenciesManager.allDependencies)
                .containsOnly(DependencyOnPlugin("CheckStyle-IDEA", null, null))
    }

    @Test
    fun requiredPluginsWithVersionApplied() {
        settingsApplier.apply(BuildExecutionDeploymentSettings(
            requiredPlugins = listOf(RequiredPlugin(plugin = "CheckStyle-IDEA", minimumVersion = "5.23.0", maximumVersion = "5.24.1"))))
        assertThat(externalDependenciesManager.allDependencies)
                .containsOnly(DependencyOnPlugin("CheckStyle-IDEA", "5.23.0", "5.24.1"))
    }

    @Test
    fun childSettingsApplied() {
        settingsApplier.apply(BuildExecutionDeploymentSettings(
            compiler = CompilerSettings(),
            buildTools = BuildToolsSettings()))
        verify {
            buildToolsSettingsApplier.apply(any())
            compilerSettingsApplier.apply(any())
        }
    }
}
