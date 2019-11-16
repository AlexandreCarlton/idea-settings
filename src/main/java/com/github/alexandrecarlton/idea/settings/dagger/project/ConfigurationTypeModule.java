package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.intellij.docker.DockerCloudType;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.UnknownConfigurationType;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerConfigurationType;
import com.intellij.sh.run.ShConfigurationType;
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.function.Supplier;
import javax.inject.Named;

@Module
public class ConfigurationTypeModule {

  private static final Logger LOG = Logger.getInstance(ConfigurationTypeModule.class);

  @Provides
  @Named("Docker")
  static DeployToServerConfigurationType provideDockerConfigurationType() {
    return DockerCloudType.getRunConfigurationType();
  }

  @Provides
  @Named("Docker")
  static Supplier<ConfigurationType> provideDockerConfigurationTypeSupplier(@Named("Docker") Lazy<DeployToServerConfigurationType> configurationType) {
    return provideIfLoaded(Plugin.DOCKER, configurationType);
  }

  @Provides
  static ShConfigurationType provideShellScriptConfigurationType() {
    return new ShConfigurationType();
  }

  @Provides
  @Named("Shell Script")
  static Supplier<ConfigurationType> provideShellScriptConfigurationTypeSupplier(Lazy<ShConfigurationType> configurationType) {
    return provideIfLoaded(Plugin.SHELL_SCRIPT, configurationType);
  }

  @Provides
  static SpringBootApplicationConfigurationType provideSpringBootConfigurationType() {
    return new SpringBootApplicationConfigurationType();
  }

  @Provides
  @Named("Spring Boot")
  static Supplier<ConfigurationType> provideSpringBootConfigurationTypeSupplier(Lazy<SpringBootApplicationConfigurationType> configurationType) {
    return provideIfLoaded(Plugin.SPRING_BOOT, configurationType);
  }

  private static Supplier<ConfigurationType> provideIfLoaded(Plugin plugin, Lazy<? extends ConfigurationType> configurationTypeSupplier) {
    if (PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))) {
      return configurationTypeSupplier::get;
    } else {
      LOG.warn("Unable to use run configuration type as '" + plugin.getName() + "' is not installed, using 'Unknown' instead.");
      return UnknownConfigurationType::getInstance;
    }
  }
}
