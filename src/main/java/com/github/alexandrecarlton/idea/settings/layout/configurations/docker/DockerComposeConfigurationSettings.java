package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDockerComposeConfigurationSettings.class)
public interface DockerComposeConfigurationSettings extends ConfigurationSettings {

  Optional<List<Path>> composeFiles();

  Optional<List<String>> services();

  Optional<List<DockerEnvironmentVariable>> environmentVariables();

  Optional<DockerComposeConfigurationOptionsSettings> options();
}
