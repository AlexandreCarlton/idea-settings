package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableSqlDialectsSettings.class)
public interface SqlDialectsSettings {

  Optional<SqlDialect> projectSqlDialect();
}
