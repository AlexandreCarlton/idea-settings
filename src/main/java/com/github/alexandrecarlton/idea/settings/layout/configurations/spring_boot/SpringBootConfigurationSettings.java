package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableSpringBootConfigurationSettings.class)
public interface SpringBootConfigurationSettings {
  String mainClass();

  Optional<SpringBootConfigurationEnvironmentSettings> environment();

  Optional<SpringBootConfigurationSpringBootSettings> springBoot();

}
