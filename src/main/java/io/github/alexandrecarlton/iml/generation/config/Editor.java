package io.github.alexandrecarlton.iml.generation.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intellij.openapi.project.Project;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * Represents general editor configuration, under 'Settings... | Editor'
 */
@Value.Immutable
@JsonDeserialize(as = ImmutableEditor.class)
public interface Editor {
  Optional<CodeStyle> codeStyle();

  default void configure(Project project) {
    codeStyle().ifPresent(codeStyle -> codeStyle.configure(project));
  }

}
