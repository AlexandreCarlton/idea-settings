package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaImportsSettings.class)
public interface JavaImportsSettings {

  Optional<Integer> classCountToUseImportWithWildcard();

  Optional<Integer> namesCountToUseStaticImportWithWildcard();
}
