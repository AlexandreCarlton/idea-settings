package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableBuildExecutionDeploymentSettings.class)
public interface BuildExecutionDeploymentSettings {

  Optional<CompilerSettings> compiler();

  List<RequiredPlugin> requiredPlugins();

}
