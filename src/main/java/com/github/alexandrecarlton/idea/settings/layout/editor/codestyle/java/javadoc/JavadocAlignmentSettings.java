package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavadocAlignmentSettings.class)
public interface JavadocAlignmentSettings {

  Optional<Boolean> alignParameterDescriptions();

  Optional<Boolean> alignThrownExceptionDescriptions();

}
