package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableCodeStyleSettings.class)
public interface CodeStyleSettings {

  Optional<JavaCodeStyleSettings> java();

  Optional<JavascriptCodeStyleSettings> javascript();

}
