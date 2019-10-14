package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.nio.file.Path;

@Value.Immutable
@JsonDeserialize(as = ImmutableRunMavenGoalSettings.class)
public interface RunMavenGoalSettings extends BeforeLaunchConfigurationSettings {

  Path workingDirectory();

  String commandLine();
}
