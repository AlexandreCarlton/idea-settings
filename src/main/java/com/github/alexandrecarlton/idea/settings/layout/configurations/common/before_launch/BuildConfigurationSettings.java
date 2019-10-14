package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableBuildConfigurationSettings.class)
public interface BuildConfigurationSettings extends BeforeLaunchConfigurationSettings {
}
