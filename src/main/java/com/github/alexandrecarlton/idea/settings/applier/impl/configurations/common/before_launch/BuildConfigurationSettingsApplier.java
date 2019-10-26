package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings;
import com.intellij.compiler.options.CompileStepBeforeRun;
import com.intellij.execution.configurations.RunConfiguration;

import javax.inject.Inject;

public class BuildConfigurationSettingsApplier implements SettingsApplier<BuildConfigurationSettings> {

  private final RunConfiguration runConfiguration;

  @Inject
  public BuildConfigurationSettingsApplier(RunConfiguration runConfiguration) {
    this.runConfiguration = runConfiguration;
  }

  @Override
  public void apply(BuildConfigurationSettings settings) {
    runConfiguration.getBeforeRunTasks().add(new CompileStepBeforeRun.MakeBeforeRunTask());
  }
}
