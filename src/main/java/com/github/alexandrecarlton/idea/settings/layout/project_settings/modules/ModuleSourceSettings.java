package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.immutables.value.Value;

import java.nio.file.Path;
import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableModuleSourceSettings.class)
public interface ModuleSourceSettings {

  Path contentRoot();

  List<String> sources();

  List<String> tests();

  List<String> resources();

  List<String> testResources();

  List<String> excluded();

}
