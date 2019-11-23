package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaArrangementSettings.class)
public interface JavaArrangementSettings {
  Optional<List<MatchingRule>> matchingRules();
}
