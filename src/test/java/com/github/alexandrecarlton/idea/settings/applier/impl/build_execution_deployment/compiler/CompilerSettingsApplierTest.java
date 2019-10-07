package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.ImmutableCompilerSettings;
import com.intellij.compiler.CompilerConfiguration;
import com.intellij.compiler.CompilerWorkspaceConfiguration;

import org.junit.Test;

public class CompilerSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<CompilerSettings> settingsApplier;
  private CompilerConfiguration compilerConfiguration;
  private CompilerWorkspaceConfiguration compilerWorkspaceConfiguration;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    compilerConfiguration = CompilerConfiguration.getInstance(project);
    compilerWorkspaceConfiguration = CompilerWorkspaceConfiguration.getInstance(project);
    settingsApplier = new CompilerSettingsApplier(compilerConfiguration, compilerWorkspaceConfiguration);
  }


  @Test
  public void addRuntimeAssertionsForNotnullAnnotatedMethodsAndParametersApplied() {
    settingsApplier.apply(ImmutableCompilerSettings.builder()
        .addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters(false)
        .build());
    assertThat(compilerConfiguration.isAddNotNullAssertions()).isFalse();
  }

  @Test
  public void buildProcessHeapSizeApplied() {
    settingsApplier.apply(ImmutableCompilerSettings.builder()
        .buildProcessHeapSizeMbytes(1234)
        .build());
    assertThat(compilerConfiguration.getBuildProcessHeapSize(0)).isEqualTo(1234);
  }

  @Test
  public void compileIndependentModulesInParallel() {
    settingsApplier.apply(ImmutableCompilerSettings.builder()
        .compileIndependentModulesInParallel(true)
        .build());
    assertThat(compilerWorkspaceConfiguration.PARALLEL_COMPILATION).isTrue();
  }

  @Test
  public void rebuildModuleOnDependencyChange() {
    settingsApplier.apply(ImmutableCompilerSettings.builder()
        .rebuildModuleOnDependencyChange(false)
        .build());
    assertThat(compilerWorkspaceConfiguration.REBUILD_ON_DEPENDENCY_CHANGE).isFalse();
  }

  @Test
  public void sharedBuildProcessVmOptions() {
    settingsApplier.apply(ImmutableCompilerSettings.builder()
        .sharedBuildProcessVmOptions("-Xms1g")
        .build());
    assertThat(compilerConfiguration.getBuildProcessVMOptions()).isEqualTo("-Xms1g");
  }
}
