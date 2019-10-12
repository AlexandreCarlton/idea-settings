package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableOverrideParameter.class)
public interface OverrideParameter {
  String key();
  String value();
}
