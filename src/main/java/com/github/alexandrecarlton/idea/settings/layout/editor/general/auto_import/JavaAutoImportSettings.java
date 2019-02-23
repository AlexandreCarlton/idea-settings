package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaAutoImportSettings.class)
public interface JavaAutoImportSettings {

  // This saves to the workspace file, which we don't know how to persist (yet).
  // Optional<Boolean> optimizeImportsOnTheFly();

  List<String> excludeFromImportAndCompletion();

}
