package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.RunConfigurationType.APPLICATION
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.RunConfigurationType.DOCKER
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.RunConfigurationType.REMOTE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch.RunConfigurationType.SPRING_BOOT
import com.intellij.execution.configurations.ConfigurationType
import java.util.function.Supplier
import javax.inject.Inject
import javax.inject.Named

class ConfigurationTypeMapper @Inject
constructor(
    @param:Named("Application") private val applicationConfigurationTypeSupplier: Supplier<ConfigurationType>,
    @param:Named("Docker") private val dockerConfigurationTypeSupplier: Supplier<ConfigurationType>,
    @param:Named("Remote") private val remoteConfigurationTypeSupplier: Supplier<ConfigurationType>,
    @param:Named("Spring Boot") private val springBootConfigurationTypeSupplier: Supplier<ConfigurationType>
) {

    fun mapRunConfigurationType(runConfigurationType: RunConfigurationType) =
        when (runConfigurationType) {
            APPLICATION -> applicationConfigurationTypeSupplier.get()
            DOCKER -> dockerConfigurationTypeSupplier.get()
            REMOTE -> remoteConfigurationTypeSupplier.get()
            SPRING_BOOT -> springBootConfigurationTypeSupplier.get()
        }
}
