package com.github.alexandrecarlton.idea.settings.layout.configurations.remote;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableRemoteConfigurationSettings.class)
public interface RemoteConfigurationSettings {

  Optional<String> host();

  Optional<Integer> port();

}
