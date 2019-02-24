package com.github.alexandrecarlton.idea.settings.layout.other_settings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableOtherSettings.class)
public interface OtherSettings {
  Optional<CheckstyleSettings> checkstyle();
}
