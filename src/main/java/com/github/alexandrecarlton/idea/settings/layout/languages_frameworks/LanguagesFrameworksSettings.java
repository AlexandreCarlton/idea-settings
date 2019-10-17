package com.github.alexandrecarlton.idea.settings.layout.languages_frameworks;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableLanguagesFrameworksSettings.class)
public interface LanguagesFrameworksSettings {

  Optional<JavascriptSettings> javascript();

  Optional<SqlDialectsSettings> sqlDialects();
}
