package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings;
import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider;
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider.RunConfigurableBeforeRunTask;
import com.intellij.openapi.diagnostic.Logger;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

public class RunAnotherConfigurationSettingsApplier implements SettingsApplier<RunAnotherConfigurationSettings> {

  private static final Logger LOG = Logger.getInstance(RunAnotherConfigurationSettingsApplier.class);

  private final List<BeforeRunTask<?>> beforeRunTasks;
  private final ConfigurationTypeMapper configurationTypeMapper;
  private final RunConfigurationBeforeRunProvider runConfigurationBeforeRunProvider;
  private final RunManager runManager;

  @Inject
  public RunAnotherConfigurationSettingsApplier(List<BeforeRunTask<?>> beforeRunTasks,
                                                ConfigurationTypeMapper configurationTypeMapper,
                                                RunConfigurationBeforeRunProvider runConfigurationBeforeRunProvider,
                                                RunManager runManager) {
    this.configurationTypeMapper = configurationTypeMapper;
    this.beforeRunTasks = beforeRunTasks;
    this.runConfigurationBeforeRunProvider = runConfigurationBeforeRunProvider;
    this.runManager = runManager;
  }

  @Override
  public void apply(RunAnotherConfigurationSettings settings) {

    RunnerAndConfigurationSettings runnerAndConfigurationSettings = settings.type()
        .map(type -> runManager.findConfigurationByTypeAndName(configurationTypeMapper.mapRunConfigurationType(type), settings.name()))
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

}
