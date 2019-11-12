package com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import java.nio.file.Path;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableShellScriptConfigurationSettings.class)
public interface ShellScriptConfigurationSettings extends ConfigurationSettings {

  Path scriptPath();

  Optional<String> scriptOptions();

  Optional<InterpreterConfigurationSettings> interpreter();

}
