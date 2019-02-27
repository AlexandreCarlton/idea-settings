package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableBuildToolsSettings.class)
public interface BuildToolsSettings {

  Optional<MavenSettings> maven();

}
