package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableModuleSettings.class)
public interface ModuleSettings {

  String name();

  List<ModuleSourceSettings> sources();

}
