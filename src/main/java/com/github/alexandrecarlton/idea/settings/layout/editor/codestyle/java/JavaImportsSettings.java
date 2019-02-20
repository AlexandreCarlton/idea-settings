package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaImportsSettings.class)
public interface JavaImportsSettings {

  Optional<Integer> classCountToUseImportWithWildcard();

  Optional<Integer> namesCountToUseStaticImportWithWildcard();
}
