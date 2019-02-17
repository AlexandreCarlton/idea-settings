package io.github.alexandrecarlton.iml.generation.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intellij.openapi.project.Project;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJava.class)
public interface Java {
  Optional<Imports> imports();

  default void configure(Project project) {
    imports().ifPresent(imports -> imports.configure(project));
  }
}
