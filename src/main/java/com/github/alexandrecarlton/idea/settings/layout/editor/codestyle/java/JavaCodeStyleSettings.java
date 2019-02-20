package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaCodeStyleSettings.class)
public interface JavaCodeStyleSettings {

  Optional<JavaImportsSettings> imports();

}
