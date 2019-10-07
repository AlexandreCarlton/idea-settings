package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavascriptSettings.class)
public interface JavascriptSettings {

  Optional<JavascriptLanguageVersion> javascriptLanguageVersion();

}
