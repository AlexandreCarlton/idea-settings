package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.ImmutableMavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;
import org.junit.Before;
import org.junit.Test;

public class MavenImportingSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<MavenImportingSettings> settingsApplier;
  private org.jetbrains.idea.maven.project.MavenImportingSettings mavenImportingSettings;

  @Before
  public void setUp() {
    mavenImportingSettings = org.jetbrains.idea.maven.project.MavenProjectsManager.getInstance(project).getImportingSettings();
    settingsApplier = new MavenImportingSettingsApplier(mavenImportingSettings);
  }

  @Test
  public void vmOptionsForImporterApplied() {
    settingsApplier.apply(ImmutableMavenImportingSettings.builder()
        .vmOptionsForImporter("-Xmx3g")
        .build());
    assertThat(mavenImportingSettings.getVmOptionsForImporter()).isEqualTo("-Xmx3g");
  }



}
