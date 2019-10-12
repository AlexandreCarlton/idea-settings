package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableSpringBootConfigurationEnvironmentSettings.class)
public interface SpringBootConfigurationEnvironmentSettings {
  Optional<String> vmOptions();

  Optional<Boolean> includeDependenciesWithProvidedScope();

  Optional<String> useClassPathOfModule();

}
