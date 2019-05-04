package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableCompilerSettings.class)
public interface CompilerSettings {
  Optional<Boolean> addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters();
  Optional<Integer> buildProcessHeapSizeMbytes();
}
