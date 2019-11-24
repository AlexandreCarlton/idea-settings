package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaForStatementSettings.class)
public interface JavaForStatementSettings {

  Optional<Wrapping> wrapping();

  Optional<Force> forceBraces();
}
