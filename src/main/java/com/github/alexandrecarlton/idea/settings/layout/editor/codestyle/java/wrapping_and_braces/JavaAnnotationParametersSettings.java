package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaAnnotationParametersSettings.class)
public interface JavaAnnotationParametersSettings {

  Optional<Wrapping> wrapping();

  Optional<Boolean> alignWhenMultiline();
}
