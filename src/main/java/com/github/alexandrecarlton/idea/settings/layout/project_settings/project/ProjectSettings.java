package com.github.alexandrecarlton.idea.settings.layout.project_settings.project;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableProjectSettings.class)
public interface ProjectSettings {

  Optional<String> projectName();

  Optional<String> projectSdk();

  Optional<ProjectLanguageLevel> projectLanguageLevel();

}
