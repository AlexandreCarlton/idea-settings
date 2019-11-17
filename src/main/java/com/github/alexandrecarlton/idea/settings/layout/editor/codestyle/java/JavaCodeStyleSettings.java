package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaCodeStyleSettings.class)
public interface JavaCodeStyleSettings {

  Optional<JavaArrangementSettings> arrangement();

  Optional<JavaImportsSettings> imports();

  Optional<JavadocSettings> javadoc();

}
