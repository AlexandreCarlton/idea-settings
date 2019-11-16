package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.remote.RemoteConfigurationType;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.inject.Named;

public class ConfigurationTypeMapper {

  private final Supplier<ConfigurationType> dockerConfigurationTypeSupplier;
  private final Supplier<ConfigurationType> shellScriptConfigurationTypeSupplier;
  private final Supplier<ConfigurationType> springBootConfigurationTypeSupplier;

  @Inject
  public ConfigurationTypeMapper(@Named("Docker") Supplier<ConfigurationType> dockerConfigurationTypeSupplier,
                                 @Named("Shell Script") Supplier<ConfigurationType> shellScriptConfigurationTypeSupplier,
                                 @Named("Spring Boot") Supplier<ConfigurationType> springBootConfigurationTypeSupplier) {
    this.dockerConfigurationTypeSupplier = dockerConfigurationTypeSupplier;
    this.shellScriptConfigurationTypeSupplier = shellScriptConfigurationTypeSupplier;
    this.springBootConfigurationTypeSupplier = springBootConfigurationTypeSupplier;
  }

  public ConfigurationType mapRunConfigurationType(RunConfigurationType runConfigurationType) {
    switch (runConfigurationType) {
      case DOCKER: return dockerConfigurationTypeSupplier.get();
      case REMOTE: return RemoteConfigurationType.getInstance();
      case SHELL_SCRIPT: return shellScriptConfigurationTypeSupplier.get();
      case SPRING_BOOT: return springBootConfigurationTypeSupplier.get();
      default:
        throw new IllegalArgumentException("Unhandled RunConfigurationType: " + runConfigurationType);
    }
  }
}
