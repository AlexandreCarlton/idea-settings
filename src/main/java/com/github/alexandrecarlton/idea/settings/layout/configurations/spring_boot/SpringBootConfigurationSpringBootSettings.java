package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableSpringBootConfigurationSpringBootSettings.class)
public interface SpringBootConfigurationSpringBootSettings {
  List<OverrideParameter> overrideParameters();
}
