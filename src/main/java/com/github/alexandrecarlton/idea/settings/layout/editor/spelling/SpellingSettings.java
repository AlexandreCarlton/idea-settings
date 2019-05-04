package com.github.alexandrecarlton.idea.settings.layout.editor.spelling;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.nio.file.Path;
import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableSpellingSettings.class)
public interface SpellingSettings {
  List<Path> dictionaries();
}
