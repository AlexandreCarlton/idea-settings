package com.github.alexandrecarlton.idea.settings.layout.editor.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableGeneralSettings.class)
public interface GeneralSettings {
  Optional<AutoImportSettings> autoImport();
}
