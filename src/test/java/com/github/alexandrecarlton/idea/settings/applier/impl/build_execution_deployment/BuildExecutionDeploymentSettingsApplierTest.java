package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.ImmutableBuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.ImmutableRequiredPlugin;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.ImmutableBuildToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.ImmutableCompilerSettings;
import com.intellij.externalDependencies.DependencyOnPlugin;
import com.intellij.externalDependencies.ExternalDependenciesManager;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BuildExecutionDeploymentSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<BuildExecutionDeploymentSettings> settingsApplier;
  private ExternalDependenciesManager externalDependenciesManager;
  @Mock private SettingsApplier<BuildToolsSettings> buildToolsSettingsApplier;
  @Mock private SettingsApplier<CompilerSettings> compilerSettingsApplier;

  @Before
  public void setUp() {
    externalDependenciesManager = ExternalDependenciesManager.getInstance(project);
    settingsApplier = new BuildExecutionDeploymentSettingsApplier(externalDependenciesManager, buildToolsSettingsApplier, compilerSettingsApplier);
  }

  @After
  public void tearDown() {
    externalDependenciesManager.setAllDependencies(Collections.emptyList());
  }

  @Test
  public void requiredPluginsApplied() {
    settingsApplier.apply(ImmutableBuildExecutionDeploymentSettings.builder()
        .addRequiredPlugins(ImmutableRequiredPlugin.builder()
            .plugin("CheckStyle-IDEA")
            .build())
        .build());
    assertThat(externalDependenciesManager.getAllDependencies())
        .containsOnly(new DependencyOnPlugin("CheckStyle-IDEA", null, null));
  }

  @Test
  public void requiredPluginsWithVersionApplied() {
    settingsApplier.apply(ImmutableBuildExecutionDeploymentSettings.builder()
        .addRequiredPlugins(ImmutableRequiredPlugin.builder()
            .plugin("CheckStyle-IDEA")
            .minimumVersion("5.23.0")
            .maximumVersion("5.24.1")
            .build())
        .build());
    assertThat(externalDependenciesManager.getAllDependencies())
        .containsOnly(new DependencyOnPlugin("CheckStyle-IDEA", "5.23.0", "5.24.1"));
  }

  @Test
  public void childSettingsApplied() {
    settingsApplier.apply(ImmutableBuildExecutionDeploymentSettings.builder()
        .compiler(ImmutableCompilerSettings.builder().build())
        .buildTools(ImmutableBuildToolsSettings.builder().build())
        .build());
    verify(buildToolsSettingsApplier).apply(ImmutableBuildToolsSettings.builder().build());
    verify(compilerSettingsApplier).apply(ImmutableCompilerSettings.builder().build());
  }

}
