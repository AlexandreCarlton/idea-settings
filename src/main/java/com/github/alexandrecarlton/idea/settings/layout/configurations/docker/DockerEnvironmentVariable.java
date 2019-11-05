package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDockerEnvironmentVariable.class)
public interface DockerEnvironmentVariable {

  Optional<String> name();

  Optional<String> value();
}
