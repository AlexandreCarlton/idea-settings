package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin
import com.intellij.docker.DockerCloudType
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.UnknownConfigurationType
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerConfigurationType
import com.intellij.sh.run.ShConfigurationType
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType
import dagger.Lazy
import dagger.Module
import dagger.Provides
import java.util.function.Supplier
import javax.inject.Named

@Module
class ConfigurationTypeModule {

    private val LOG = Logger.getInstance(ConfigurationTypeModule::class.java)

    @Provides
    @Named("Docker")
    internal fun provideDockerConfigurationType(): DeployToServerConfigurationType =
        DockerCloudType.getRunConfigurationType()

    @Provides
    @Named("Docker")
    internal fun provideDockerConfigurationTypeSupplier(@Named("Docker") configurationType: Lazy<DeployToServerConfigurationType>) =
        provideIfLoaded(Plugin.DOCKER, configurationType)

    @Provides
    internal fun provideShellScriptConfigurationType() = ShConfigurationType()

    @Provides
    @Named("Shell Script")
    internal fun provideShellScriptConfigurationTypeSupplier(configurationType: Lazy<ShConfigurationType>) =
        provideIfLoaded(Plugin.SHELL_SCRIPT, configurationType)

    @Provides
    internal fun provideSpringBootConfigurationType() = SpringBootApplicationConfigurationType()

    @Provides
    @Named("Spring Boot")
    internal fun provideSpringBootConfigurationTypeSupplier(configurationType: Lazy<SpringBootApplicationConfigurationType>) =
        provideIfLoaded(Plugin.SPRING_BOOT, configurationType)

    private fun provideIfLoaded(plugin: Plugin, configurationTypeSupplier: Lazy<out ConfigurationType>): Supplier<ConfigurationType> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id))) {
          Supplier { configurationTypeSupplier.get() }
        } else {
          LOG.warn("Unable to use run configuration type as '" + plugin.pluginName + "' is not installed, using 'Unknown' instead.")
          Supplier { UnknownConfigurationType.getInstance() }
        }
}
