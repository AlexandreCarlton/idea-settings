package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavascriptImportsSettings.class)
public interface JavascriptImportsSettings {

  Optional<Boolean> usePathsRelativeToTheProjectResourceOrSourcesRoots();
}
