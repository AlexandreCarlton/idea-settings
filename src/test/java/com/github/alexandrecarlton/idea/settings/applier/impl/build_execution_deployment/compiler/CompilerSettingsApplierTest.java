package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.ImmutableCompilerSettings;
import com.intellij.compiler.CompilerConfiguration;

import org.junit.Test;

public class CompilerSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<CompilerSettings> settingsApplier;
  private CompilerConfiguration compilerConfiguration;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    compilerConfiguration = CompilerConfiguration.getInstance(project);
    settingsApplier = new CompilerSettingsApplier(compilerConfiguration);
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
}
