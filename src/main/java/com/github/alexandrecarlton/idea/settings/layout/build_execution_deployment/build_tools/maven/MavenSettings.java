package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableMavenSettings.class)
public interface MavenSettings {
  Optional<MavenImportingSettings> importing();
}
