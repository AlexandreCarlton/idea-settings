package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.intellij.compiler.CompilerConfiguration;

import javax.inject.Inject;

public class CompilerSettingsApplier implements SettingsApplier<CompilerSettings> {
  private final CompilerConfiguration compilerConfiguration;

  @Inject
  public CompilerSettingsApplier(CompilerConfiguration compilerConfiguration) {
    this.compilerConfiguration = compilerConfiguration;
  }

  @Override
  public void apply(CompilerSettings settings) {
    settings.addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters()
        .ifPresent(compilerConfiguration::setAddNotNullAssertions);
    settings.buildProcessHeapSizeMbytes().ifPresent(compilerConfiguration::setBuildProcessHeapSize);
  }
}
