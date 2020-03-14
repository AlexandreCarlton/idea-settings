package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.SpringBootSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootConfigurationFrameDeactivationPolicy.UPDATE_CLASSES_AND_RESOURCES
import com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootConfigurationUpdateActionPolicy.HOT_SWAP_CLASSES_AND_UPDATE_TRIGGER_FILE_IF_FAILED
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.execution.RunManager
import com.intellij.spring.boot.run.SpringBootAdditionalParameter
import com.intellij.spring.boot.run.SpringBootApplicationRunConfiguration
import com.intellij.spring.boot.run.update.UpdateClassesAndResourcesPolicy
import com.intellij.spring.boot.run.update.UpdateClassesAndTriggerFilePolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SpringBootSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SpringBootSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        runManager = RunManager.getInstance(project)
        settingsApplier = SpringBootSettingsApplier(project, runManager)
    }

    @Test
    fun basicSpringConfiguration() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot Basic",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application")))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot Basic")
        assertThat(configuration.springBootMainClass).isEqualTo("com.Application")
    }

    @Test
    fun dependenciesWithProvidedScopeApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With Provided",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    environment = SpringBootConfigurationEnvironmentSettings(
                        includeDependenciesWithProvidedScope = false))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Provided")
        assertThat(configuration.isIncludeProvidedScope).isFalse()
    }

    // TODO: test useClassPathOfModule - will likely require module creation.

    @Test
    fun vmOptionsApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With VM Options",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    environment = SpringBootConfigurationEnvironmentSettings(
                        vmOptions = "-Xmx123m"))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With VM Options")
        assertThat(configuration.vmParameters).isEqualTo("-Xmx123m")
    }

    @Test
    fun enableDebugOutputApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With Debug Output Enabled",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    enableDebugOutput = true))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Debug Output Enabled")
        assertThat(configuration.isDebugMode).isTrue()
    }

    @Test
    fun hideBannerApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With Hidden Banner",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    hideBanner = true))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Hidden Banner")
        assertThat(configuration.isHideBanner).isTrue()
    }

    @Test
    fun enableLaunchOptimizationApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With Launch Optimization Disabled",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    enableLaunchOptimization = false))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Launch Optimization Disabled")
        assertThat(configuration.isEnableLaunchOptimization).isFalse()
    }

    @Test
    fun enableJmxAgentApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With JMX Agent Disabled",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    enableJmxAgent = false))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With JMX Agent Disabled")
        assertThat(configuration.isEnableJmxAgent).isFalse()
    }

    @Test
    fun onUpdateActionApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With Update Action",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    runningApplicationUpdatePolicies = SpringBootConfigurationRunningApplicationUpdatePoliciesSettings(
                        onUpdateAction = HOT_SWAP_CLASSES_AND_UPDATE_TRIGGER_FILE_IF_FAILED)))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Update Action")
        assertThat(configuration.updateActionUpdatePolicy).isInstanceOf(UpdateClassesAndTriggerFilePolicy::class.java)
    }

    @Test
    fun onFrameDeactivationApplied() {
        settingsApplier.apply(SpringBootSettings(
            name = "Spring Boot With Frame Deactivation",
            configuration = SpringBootConfigurationSettings(
                mainClass = "com.Application",
                springBoot = SpringBootConfigurationSpringBootSettings(
                    runningApplicationUpdatePolicies = SpringBootConfigurationRunningApplicationUpdatePoliciesSettings(
                        onFrameDeactivation = UPDATE_CLASSES_AND_RESOURCES)))))

        val configuration = getSpringBootApplicationRunConfiguration("Spring Boot With Frame Deactivation")
        assertThat(configuration.frameDeactivationUpdatePolicy).isInstanceOf(UpdateClassesAndResourcesPolicy::class.java)
    }

    @Test
    fun overrideParametersApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With Override",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    springBoot = SpringBootConfigurationSpringBootSettings(
                        overrideParameters = listOf(OverrideParameter(name = "Key", value = "Value"))))))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With Override")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.additionalParameters).containsExactly(SpringBootAdditionalParameter(true, "Key", "Value"))
    }

    private fun getSpringBootApplicationRunConfiguration(name: String): SpringBootApplicationRunConfiguration {
        val runnerAndConfigurationSettings = runManager.findConfigurationByName(name)!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        return configuration
    }
}
