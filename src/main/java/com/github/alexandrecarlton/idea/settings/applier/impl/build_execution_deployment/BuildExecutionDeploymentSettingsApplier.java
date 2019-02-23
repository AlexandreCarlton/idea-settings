package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;

import javax.inject.Inject;

public class BuildExecutionDeploymentSettingsApplier implements SettingsApplier<BuildExecutionDeploymentSettings> {

  private final SettingsApplier<CompilerSettings> compilerSettingsApplier;

  @Inject
  public BuildExecutionDeploymentSettingsApplier(SettingsApplier<CompilerSettings> compilerSettingsApplier) {
    this.compilerSettingsApplier = compilerSettingsApplier;
  }

  @Override
  public void apply(BuildExecutionDeploymentSettings settings) {
    settings.compiler().ifPresent(compilerSettingsApplier::apply);

  }
}
