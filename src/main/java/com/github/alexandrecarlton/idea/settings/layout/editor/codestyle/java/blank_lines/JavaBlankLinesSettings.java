package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaBlankLinesSettings.class)
public interface JavaBlankLinesSettings {

  Optional<JavaKeepMaximumBlankLinesSettings> keepMaximumBlankLines();

  Optional<JavaMinimumBlankLinesSettings> minimumBlankLines();
}
