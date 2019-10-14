package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableSpringBootConfigurationSettings.class)
public interface SpringBootConfigurationSettings {
  String mainClass();

  Optional<SpringBootConfigurationEnvironmentSettings> environment();

  Optional<SpringBootConfigurationSpringBootSettings> springBoot();

  List<BeforeLaunchConfigurationSettings> beforeLaunch();

}
