package com.github.alexandrecarlton.idea.settings.layout.configurations.remote;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableRemoteSettings.class)
public interface RemoteSettings {

  String name();

  Optional<RemoteConfigurationSettings> configuration();

}
