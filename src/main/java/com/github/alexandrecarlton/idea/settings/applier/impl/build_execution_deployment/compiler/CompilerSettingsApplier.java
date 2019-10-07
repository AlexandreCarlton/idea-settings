package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.intellij.compiler.CompilerConfiguration;
import com.intellij.compiler.CompilerWorkspaceConfiguration;

import javax.inject.Inject;

public class CompilerSettingsApplier implements SettingsApplier<CompilerSettings> {
  private final CompilerConfiguration compilerConfiguration;
  private final CompilerWorkspaceConfiguration compilerWorkspaceConfiguration;

  @Inject
  public CompilerSettingsApplier(
      CompilerConfiguration compilerConfiguration,
      CompilerWorkspaceConfiguration compilerWorkspaceConfiguration) {
    this.compilerConfiguration = compilerConfiguration;
    this.compilerWorkspaceConfiguration = compilerWorkspaceConfiguration;
  }

  @Override
  public void apply(CompilerSettings settings) {
    settings.addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters()
        .ifPresent(compilerConfiguration::setAddNotNullAssertions);
    settings.buildProcessHeapSizeMbytes().ifPresent(compilerConfiguration::setBuildProcessHeapSize);
    settings.compileIndependentModulesInParallel()
        .ifPresent(parallel -> compilerWorkspaceConfiguration.PARALLEL_COMPILATION = parallel);
  }
}
