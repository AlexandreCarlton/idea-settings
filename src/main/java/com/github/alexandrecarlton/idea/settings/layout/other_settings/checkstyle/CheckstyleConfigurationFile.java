package com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.nio.file.Path;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableCheckstyleConfigurationFile.class)
public interface CheckstyleConfigurationFile {
  @Value.Default
  default boolean active() {
    return false;
  }
  String description();

  String file();
}
