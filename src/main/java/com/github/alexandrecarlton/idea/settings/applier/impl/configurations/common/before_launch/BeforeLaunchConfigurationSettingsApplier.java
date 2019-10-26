package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings;

import javax.inject.Inject;

public class BeforeLaunchConfigurationSettingsApplier implements SettingsApplier<BeforeLaunchConfigurationSettings> {

  private final SettingsApplier<BuildConfigurationSettings> buildConfigurationSettingsApplier;
  private final SettingsApplier<RunMavenGoalSettings> runMavenGoalSettingsApplier;

  @Inject
  public BeforeLaunchConfigurationSettingsApplier(SettingsApplier<BuildConfigurationSettings> buildConfigurationSettingsApplier,
                                                  SettingsApplier<RunMavenGoalSettings> runMavenGoalSettingsApplier) {
    this.buildConfigurationSettingsApplier = buildConfigurationSettingsApplier;
    this.runMavenGoalSettingsApplier = runMavenGoalSettingsApplier;
  }


  @Override
  public void apply(BeforeLaunchConfigurationSettings settings) {
    if (settings instanceof BuildConfigurationSettings) {
      buildConfigurationSettingsApplier.apply((BuildConfigurationSettings) settings);
    } else if (settings instanceof RunMavenGoalSettings) {
      runMavenGoalSettingsApplier.apply((RunMavenGoalSettings) settings);
    } else {
      throw new IllegalArgumentException("Unhandled settings: " + settings);
    }
  }
}
