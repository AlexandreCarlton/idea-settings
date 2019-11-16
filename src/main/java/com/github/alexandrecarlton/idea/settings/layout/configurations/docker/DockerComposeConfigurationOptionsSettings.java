package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDockerComposeConfigurationOptionsSettings.class)
public interface DockerComposeConfigurationOptionsSettings {

  Optional<Boolean> buildForceBuildImages();

}
