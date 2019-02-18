package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableCodeStyleSettings.class)
public interface CodeStyleSettings {

  Optional<JavaSettings> java();

}
