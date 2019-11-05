package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDockerImageConfigurationSettings.class)
public interface DockerImageConfigurationSettings extends ConfigurationSettings {

  Optional<String> imageId();

  Optional<String> containerName();

  Optional<DockerPublishToHostInterface> publishExposedPortsToTheHostInterfaces();

  Optional<DockerExecutableSettings> executable();

  Optional<List<DockerPortBinding>> bindPorts();

  // TODO: bindMounts

  Optional<List<DockerEnvironmentVariable>> environmentVariables();

  Optional<String> runOptions();

}
