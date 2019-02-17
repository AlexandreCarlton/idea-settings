package io.github.alexandrecarlton.iml.generation.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intellij.openapi.project.Project;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableIdeaConfig.class)
public interface IdeaConfig {
  Optional<Editor> editor();

  default void configure(Project project) {
    editor().ifPresent(editor -> editor.configure(project));
  }
}

