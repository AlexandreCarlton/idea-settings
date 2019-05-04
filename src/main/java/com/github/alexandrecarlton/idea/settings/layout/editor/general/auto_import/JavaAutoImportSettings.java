package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaAutoImportSettings.class)
public interface JavaAutoImportSettings {

  Optional<Boolean> optimizeImportsOnTheFly();

  List<String> excludeFromImportAndCompletion();

}
