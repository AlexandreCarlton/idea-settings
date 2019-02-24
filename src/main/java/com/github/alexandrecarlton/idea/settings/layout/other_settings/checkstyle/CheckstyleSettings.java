package com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableCheckstyleSettings.class)
public interface CheckstyleSettings {

  Optional<String> checkstyleVersion();

  Optional<CheckstyleScanScope> scanScope();

  Optional<Boolean> treatCheckstyleErrorsAsWarnings();

  List<CheckstyleConfigurationFile> configurationFiles();

}
