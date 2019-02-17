package io.github.alexandrecarlton.iml.generation.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intellij.openapi.project.Project;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableCodeStyle.class)
public interface CodeStyle {
  Optional<Java> java();

  default void configure(Project project) {
    java().ifPresent(java -> java.configure(project));
  }
}
