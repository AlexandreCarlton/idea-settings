package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunConfigurationType;
import com.intellij.docker.DockerCloudType;
import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.UnknownConfigurationType;
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider;
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider.RunConfigurableBeforeRunTask;
import com.intellij.execution.remote.RemoteConfigurationType;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.sh.run.ShConfigurationType;
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import javax.inject.Inject;

public class RunAnotherConfigurationSettingsApplier implements SettingsApplier<RunAnotherConfigurationSettings> {

  private static final Logger LOG = Logger.getInstance(RunAnotherConfigurationSettingsApplier.class);

  private final List<BeforeRunTask<?>> beforeRunTasks;
  private final RunConfigurationBeforeRunProvider runConfigurationBeforeRunProvider;
  private final RunManager runManager;

  @Inject
  public RunAnotherConfigurationSettingsApplier(List<BeforeRunTask<?>> beforeRunTasks,
                                                RunConfigurationBeforeRunProvider runConfigurationBeforeRunProvider,
                                                RunManager runManager) {
    this.beforeRunTasks = beforeRunTasks;
    this.runConfigurationBeforeRunProvider = runConfigurationBeforeRunProvider;
    this.runManager = runManager;
  }

  @Override
  public void apply(RunAnotherConfigurationSettings settings) {

    RunnerAndConfigurationSettings runnerAndConfigurationSettings = settings.type()
        .map(type -> runManager.findConfigurationByTypeAndName(toConfigurationType(type), settings.name()))
        .orElse(runManager.findConfigurationByName(settings.name()));
    if (runnerAndConfigurationSettings == null) {
      LOG.warn("Unable to find Run Configuration with name " + settings.name()
          + settings.type()
          .map(Objects::toString)
          .map(" and type: "::concat)
          .orElse("")
          + ".");
      return;
    }

    final RunConfigurableBeforeRunTask runConfigurableBeforeRunTask = runConfigurationBeforeRunProvider.createTask(runnerAndConfigurationSettings.getConfiguration());
    runConfigurableBeforeRunTask.setSettingsWithTarget(runnerAndConfigurationSettings, null);
    beforeRunTasks.add(runConfigurableBeforeRunTask);
  }

  // TODO: Extract this out into a Supplier<ConfigurationType>?
  // Then we can just have @Named("Docker") Supplier<ConfigurationType> dockerConfigurationTypeSupplier;
  private static ConfigurationType toConfigurationType(RunConfigurationType runConfigurationType) {
    switch (runConfigurationType) {
      case DOCKER: return getTypeIfPluginLoaded(Plugin.DOCKER, DockerCloudType::getRunConfigurationType);
      case REMOTE: return RemoteConfigurationType.getInstance();
      case SHELL_SCRIPT: return getTypeIfPluginLoaded(Plugin.SHELL_SCRIPT, ShConfigurationType::new);
      case SPRING_BOOT: return getTypeIfPluginLoaded(Plugin.SPRING_BOOT, SpringBootApplicationConfigurationType::getInstance);
      default:
        throw new IllegalArgumentException("Unhandled RunConfigurationType: " + runConfigurationType);
    }
  }

  private static ConfigurationType getTypeIfPluginLoaded(Plugin plugin, Supplier<ConfigurationType> configurationTypeSupplier) {
    if (PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))) {
      return configurationTypeSupplier.get();
    }
    LOG.warn("Unable to load configuration type as plugin '" + plugin.getName() + "' is not loaded.");
    return UnknownConfigurationType.getInstance();
  }
}
