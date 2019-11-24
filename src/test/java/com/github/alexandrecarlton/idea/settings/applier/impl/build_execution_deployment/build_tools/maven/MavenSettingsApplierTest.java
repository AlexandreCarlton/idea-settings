package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.ImmutableMavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.ImmutableMavenSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;
import java.nio.file.Paths;
import org.jetbrains.idea.maven.project.MavenGeneralSettings;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MavenSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<MavenSettings> settingsApplier;
  private MavenGeneralSettings mavenGeneralSettings;
  @Mock private SettingsApplier<MavenImportingSettings> mavenImportingSettingsApplier;

  @Before
  public void setUp() {
    mavenGeneralSettings = MavenProjectsManager.getInstance(project).getGeneralSettings();
    settingsApplier = new MavenSettingsApplier(mavenGeneralSettings, mavenImportingSettingsApplier);
  }

  @Test
  public void vmOptionsForImporterApplied() {
    settingsApplier.apply(ImmutableMavenSettings.builder()
        .mavenHomeDirectory(Paths.get("/usr"))
        .build());
    assertThat(mavenGeneralSettings.getMavenHome()).isEqualTo("/usr");
  }

  @Test
  public void importSettingsApplied() {
    settingsApplier.apply(ImmutableMavenSettings.builder()
        .importing(ImmutableMavenImportingSettings.builder().build())
        .build());
    verify(mavenImportingSettingsApplier).apply(ImmutableMavenImportingSettings.builder().build());
  }
}
