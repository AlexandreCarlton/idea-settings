package com.github.alexandrecarlton.idea.settings.layout.configurations.remote;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableRemoteSettings.class)
public interface RemoteSettings extends ConfigurationSettings {

  Optional<RemoteConfigurationSettings> configuration();

}
