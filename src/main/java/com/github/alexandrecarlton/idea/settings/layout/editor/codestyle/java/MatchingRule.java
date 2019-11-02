package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableMatchingRule.class)
public interface MatchingRule {

  Optional<MatchingRuleType> type();

  List<MatchingRuleModifier> modifier();

  Optional<String> name();

  Optional<MatchingRuleOrder> order();

}
