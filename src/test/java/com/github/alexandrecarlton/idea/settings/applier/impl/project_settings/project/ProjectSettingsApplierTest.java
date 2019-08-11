package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ImmutableProjectSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.project.ex.ProjectEx;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.pom.java.LanguageLevel;

import org.junit.Before;
import org.junit.Test;

public class ProjectSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<ProjectSettings> settingsApplier;
  private LanguageLevelProjectExtension languageLevelProjectExtension;
  private ProjectRootManager projectRootManager;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    languageLevelProjectExtension = LanguageLevelProjectExtension.getInstance(project);
    projectRootManager = ProjectRootManager.getInstance(project);
    settingsApplier = new ProjectSettingsApplier(languageLevelProjectExtension, (ProjectEx) project, projectRootManager);
  }

  @Test
  public void projectNameApplied() {
    settingsApplier.apply(ImmutableProjectSettings.builder()
        .projectName("my-project-name")
        .build());
    assertThat(project.getName()).isEqualTo("my-project-name");
  }

  @Test
  public void projectSdkApplied() {
    WriteAction.runAndWait(() -> {
      settingsApplier.apply(ImmutableProjectSettings.builder()
          .projectSdk("my-project-sdk")
          .build());
    });
    assertThat(projectRootManager.getProjectSdkName()).isEqualTo("my-project-sdk");
  }

  @Test
  public void projectLanguageLevelApplied() {
    settingsApplier.apply(ImmutableProjectSettings.builder()
        .projectLanguageLevel(ProjectLanguageLevel.JAVA_6)
        .build());
    assertThat(languageLevelProjectExtension.getLanguageLevel()).isEqualByComparingTo(LanguageLevel.JDK_1_6);
  }

}
