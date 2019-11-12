package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings;
import com.intellij.compiler.options.CompileStepBeforeRun.MakeBeforeRunTask;
import com.intellij.execution.BeforeRunTask;
import java.util.List;
import javax.inject.Inject;

public class BuildConfigurationSettingsApplier implements SettingsApplier<BuildConfigurationSettings> {

  private final List<BeforeRunTask<?>> beforeRunTasks;

  @Inject
  public BuildConfigurationSettingsApplier(List<BeforeRunTask<?>> beforeRunTasks) {
    this.beforeRunTasks = beforeRunTasks;
  }

  @Override
  public void apply(BuildConfigurationSettings settings) {
    final MakeBeforeRunTask makeBeforeRunTask = new MakeBeforeRunTask();
    beforeRunTasks.add(makeBeforeRunTask);
  }
}
