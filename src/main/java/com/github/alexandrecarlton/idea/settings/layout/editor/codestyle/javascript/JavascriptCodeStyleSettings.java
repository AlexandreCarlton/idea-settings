package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavascriptCodeStyleSettings.class)
public interface JavascriptCodeStyleSettings {
  Optional<JavascriptImportsSettings> imports();
}
