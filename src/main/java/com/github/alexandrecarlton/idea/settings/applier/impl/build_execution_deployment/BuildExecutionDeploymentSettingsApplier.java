package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.intellij.externalDependencies.DependencyOnPlugin;
import com.intellij.externalDependencies.ExternalDependenciesManager;

import javax.inject.Inject;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BuildExecutionDeploymentSettingsApplier implements SettingsApplier<BuildExecutionDeploymentSettings> {

  private final ExternalDependenciesManager externalDependenciesManager;
  private final SettingsApplier<BuildToolsSettings> buildToolsSettingsApplier;
  private final SettingsApplier<CompilerSettings> compilerSettingsApplier;

  @Inject
  public BuildExecutionDeploymentSettingsApplier(ExternalDependenciesManager externalDependenciesManager,
                                                 SettingsApplier<BuildToolsSettings> buildToolsSettingsApplier,
                                                 SettingsApplier<CompilerSettings> compilerSettingsApplier) {
    this.externalDependenciesManager = externalDependenciesManager;
    this.buildToolsSettingsApplier = buildToolsSettingsApplier;
    this.compilerSettingsApplier = compilerSettingsApplier;
  }

  @Override
  public void apply(BuildExecutionDeploymentSettings settings) {
    externalDependenciesManager.setAllDependencies(Stream.concat(
        externalDependenciesManager.getAllDependencies().stream(),
        settings.requiredPlugins()
            .stream()
            .map(required -> new DependencyOnPlugin(
                required.plugin(),
                required.minimumVersion().orElse(null),
                required.maximumVersion().orElse(null))))
        .collect(toList()));

    settings.buildTools().ifPresent(buildToolsSettingsApplier::apply);
    settings.compiler().ifPresent(compilerSettingsApplier::apply);
  }
}
