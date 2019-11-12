package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableRunAnotherConfigurationSettings.class)
public interface RunAnotherConfigurationSettings extends BeforeLaunchConfigurationSettings {

  String name();

  Optional<RunConfigurationType> type();
}
