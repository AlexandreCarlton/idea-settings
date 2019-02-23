package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableAutoImportSettings.class)
public interface AutoImportSettings {
  Optional<JavaAutoImportSettings> java();
}
