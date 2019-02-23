package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableRequiredPlugin.class)
public interface RequiredPlugin {
  String plugin();

  Optional<String> minimumVersion();

  Optional<String> maximumVersion();
}
