package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.SpringBootSettings
import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.spring.boot.run.SpringBootAdditionalParameter
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType
import com.intellij.spring.boot.run.SpringBootApplicationRunConfiguration
import com.intellij.spring.boot.run.update.SpringBootApplicationUpdatePolicy
import com.intellij.spring.boot.run.update.UpdateClassesAndResourcesPolicy
import com.intellij.spring.boot.run.update.UpdateClassesAndTriggerFilePolicy
import com.intellij.spring.boot.run.update.UpdateResourcesPolicy
import com.intellij.spring.boot.run.update.UpdateTriggerFilePolicy
import javax.inject.Inject

class SpringBootSettingsApplier @Inject
constructor(private val project: Project, private val runManager: RunManager) : SettingsApplier<SpringBootSettings> {

    override fun apply(settings: SpringBootSettings) {
        val configuration = SpringBootApplicationRunConfiguration(
            project,
            SpringBootApplicationConfigurationType().defaultConfigurationFactory,
            settings.name)
        configuration.setMainClassName(settings.configuration.mainClass)
        settings.configuration.environment?.includeDependenciesWithProvidedScope?.let { configuration.isIncludeProvidedScope = it }
        settings.configuration.environment?.useClasspathOfModule?.let { configuration.setModuleName(it) }
        settings.configuration.environment?.vmOptions?.let { configuration.vmParameters = it }

        settings.configuration.springBoot?.enableDebugOutput?.let { configuration.isDebugMode = it }
        settings.configuration.springBoot?.hideBanner?.let { configuration.isHideBanner = it }
        settings.configuration.springBoot?.enableLaunchOptimization?.let { configuration.isEnableLaunchOptimization = it }
        settings.configuration.springBoot?.enableJmxAgent?.let { configuration.isEnableJmxAgent = it }

        settings.configuration.springBoot?.runningApplicationUpdatePolicies?.onUpdateAction
            ?.let(this::toSpringBootApplicationUpdatePolicy)
            ?.let { configuration.updateActionUpdatePolicy = it }
        settings.configuration.springBoot?.runningApplicationUpdatePolicies?.onFrameDeactivation
            ?.let(this::toSpringBootApplicationUpdatePolicy)
            ?.let { configuration.frameDeactivationUpdatePolicy = it }

        settings.configuration.springBoot?.overrideParameters
            ?.map { SpringBootAdditionalParameter(true, it.name, it.value) }
            ?.let { configuration.additionalParameters = it }

        val runnerAndConfigurationSettings = runManager.createConfiguration(configuration, SpringBootApplicationConfigurationType().defaultConfigurationFactory)
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }


    private fun toSpringBootApplicationUpdatePolicy(policy: SpringBootConfigurationUpdateActionPolicy) =
        when(policy) {
            SpringBootConfigurationUpdateActionPolicy.DO_NOTHING -> null
            SpringBootConfigurationUpdateActionPolicy.UPDATE_RESOURCES -> UpdateResourcesPolicy()
            SpringBootConfigurationUpdateActionPolicy.UPDATE_CLASSES_AND_RESOURCES -> UpdateClassesAndResourcesPolicy()
            SpringBootConfigurationUpdateActionPolicy.UPDATE_TRIGGER_FILE -> UpdateTriggerFilePolicy()
            SpringBootConfigurationUpdateActionPolicy.HOT_SWAP_CLASSES_AND_UPDATE_TRIGGER_FILE_IF_FAILED -> UpdateClassesAndTriggerFilePolicy()
        }

    private fun toSpringBootApplicationUpdatePolicy(policy: SpringBootConfigurationFrameDeactivationPolicy) =
        when(policy) {
            SpringBootConfigurationFrameDeactivationPolicy.DO_NOTHING -> null
            SpringBootConfigurationFrameDeactivationPolicy.UPDATE_RESOURCES -> UpdateResourcesPolicy()
            SpringBootConfigurationFrameDeactivationPolicy.UPDATE_CLASSES_AND_RESOURCES -> UpdateClassesAndResourcesPolicy()
        }
}
