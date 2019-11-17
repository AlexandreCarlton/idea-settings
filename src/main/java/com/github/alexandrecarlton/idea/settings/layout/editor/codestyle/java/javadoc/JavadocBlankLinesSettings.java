package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavadocBlankLinesSettings.class)
public interface JavadocBlankLinesSettings {

  Optional<Boolean> afterDescription();

  Optional<Boolean> afterParameterDescriptions();

  Optional<Boolean> afterReturnTag();

}
