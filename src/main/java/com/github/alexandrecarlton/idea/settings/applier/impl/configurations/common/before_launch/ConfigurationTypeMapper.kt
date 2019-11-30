package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType.DOCKER
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType.REMOTE
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType.SHELL_SCRIPT
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType.SPRING_BOOT
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.remote.RemoteConfigurationType
import java.util.function.Supplier
import javax.inject.Inject
import javax.inject.Named

class ConfigurationTypeMapper @Inject
constructor(@param:Named("Docker") private val dockerConfigurationTypeSupplier: Supplier<ConfigurationType>,
            @param:Named("Shell Script") private val shellScriptConfigurationTypeSupplier: Supplier<ConfigurationType>,
            @param:Named("Spring Boot") private val springBootConfigurationTypeSupplier: Supplier<ConfigurationType>) {

    fun mapRunConfigurationType(runConfigurationType: RunConfigurationType) =
        when (runConfigurationType) {
            DOCKER -> dockerConfigurationTypeSupplier.get()
            REMOTE -> RemoteConfigurationType.getInstance()
            SHELL_SCRIPT -> shellScriptConfigurationTypeSupplier.get()
            SPRING_BOOT -> springBootConfigurationTypeSupplier.get()
        }
}
