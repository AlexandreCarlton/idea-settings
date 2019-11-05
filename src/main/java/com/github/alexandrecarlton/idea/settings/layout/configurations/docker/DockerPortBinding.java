package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDockerPortBinding.class)
public interface DockerPortBinding {

  Optional<Integer> hostPort();

  Optional<Integer> containerPort();

  Optional<DockerPortBindingProtocol> protocol();

  Optional<String> hostIp();

}
