package com.github.alexandrecarlton.idea.settings.layout.configurations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableConfigurationsSettings.class)
public interface ConfigurationsSettings {

  List<RemoteSettings> remote();

  List<SpringBootSettings> springBoot();

}
