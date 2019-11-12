package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.nio.file.Path;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableInterpreterConfigurationSettings.class)
public interface InterpreterConfigurationSettings {

  Optional<Path> interpreterPath();

  Optional<String> interpreterOptions();

}
