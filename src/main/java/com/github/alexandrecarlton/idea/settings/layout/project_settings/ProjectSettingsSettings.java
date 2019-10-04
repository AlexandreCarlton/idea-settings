package com.github.alexandrecarlton.idea.settings.layout.project_settings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;

import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableProjectSettingsSettings.class)
public interface ProjectSettingsSettings {
  Optional<ProjectSettings> project();

  List<ModuleSettings> modules();
}
