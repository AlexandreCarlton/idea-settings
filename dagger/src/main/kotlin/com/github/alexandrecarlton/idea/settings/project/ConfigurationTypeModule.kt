package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.common.Plugin
import com.intellij.docker.DockerCloudType
import com.intellij.execution.application.ApplicationConfigurationType
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.UnknownConfigurationType
import com.intellij.execution.remote.RemoteConfigurationType
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
object ConfigurationTypeModule {

    private val LOG = Logger.getInstance(ConfigurationTypeModule::class.java)

    @Provides
    fun provideApplicationConfigurationType() = ApplicationConfigurationType.getInstance()

    @Provides
    @Named("Application")
    fun provideApplicationConfigurationTypeSupplier(configurationType: Lazy<ApplicationConfigurationType>) =
        provideIfLoaded(Plugin.JAVA, configurationType)

    @Provides
    @Named("Docker")
    fun provideDockerConfigurationType(): DeployToServerConfigurationType =
        DockerCloudType.getRunConfigurationType()

    @Provides
    @Named("Docker")
    fun provideDockerConfigurationTypeSupplier(@Named("Docker") configurationType: Lazy<DeployToServerConfigurationType>) =
        provideIfLoaded(Plugin.DOCKER, configurationType)

    @Provides
    fun provideRemoteConfigurationType() = RemoteConfigurationType.getInstance()

    @Provides
    @Named("Remote")
    fun provideRemoteConfigurationTypeSupplier(configurationType: Lazy<RemoteConfigurationType>) =
        provideIfLoaded(Plugin.JAVA, configurationType)

    @Provides
    fun provideShellScriptConfigurationType() = ShConfigurationType()

    @Provides
    @Named("Shell Script")
    fun provideShellScriptConfigurationTypeSupplier(configurationType: Lazy<ShConfigurationType>) =
        provideIfLoaded(Plugin.SHELL_SCRIPT, configurationType)

    @Provides
    fun provideSpringBootConfigurationType() = SpringBootApplicationConfigurationType()

    @Provides
    @Named("Spring Boot")
    fun provideSpringBootConfigurationTypeSupplier(configurationType: Lazy<SpringBootApplicationConfigurationType>) =
        provideIfLoaded(Plugin.SPRING_BOOT, configurationType)

    private fun provideIfLoaded(plugin: Plugin, configurationTypeSupplier: Lazy<out ConfigurationType>): Supplier<ConfigurationType> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id))) {
            Supplier { configurationTypeSupplier.get() }
        } else {
            LOG.warn("Unable to use run configuration type as '" + plugin.pluginName + "' is not installed, using 'Unknown' instead.")
            Supplier { UnknownConfigurationType.getInstance() }
        }
}
