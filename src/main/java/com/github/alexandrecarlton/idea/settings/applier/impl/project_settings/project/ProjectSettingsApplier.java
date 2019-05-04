package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;
import com.intellij.openapi.project.ex.ProjectEx;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.pom.java.LanguageLevel;

import javax.inject.Inject;

public class ProjectSettingsApplier implements SettingsApplier<ProjectSettings> {

  private final LanguageLevelProjectExtension languageLevelProjectExtension;
  private final ProjectEx projectEx;
  private final ProjectRootManager projectRootManager;

  @Inject
  public ProjectSettingsApplier(LanguageLevelProjectExtension languageLevelProjectExtension,
                                ProjectEx projectEx,
                                ProjectRootManager projectRootManager) {
    this.languageLevelProjectExtension = languageLevelProjectExtension;
    this.projectEx = projectEx;
    this.projectRootManager = projectRootManager;
  }

  @Override
  public void apply(ProjectSettings settings) {
    settings.projectName().ifPresent(projectEx::setProjectName);
    settings.projectSdk().ifPresent(projectRootManager::setProjectSdkName);
    settings.projectLanguageLevel()
        .map(this::toLanguageLevel)
        .ifPresent(languageLevelProjectExtension::setLanguageLevel);
  }

  private LanguageLevel toLanguageLevel(ProjectLanguageLevel level) {
    switch (level) {
      case JAVA_1_3: return LanguageLevel.JDK_1_3;
      case JAVA_1_4: return LanguageLevel.JDK_1_4;
      case JAVA_5: return LanguageLevel.JDK_1_5;
      case JAVA_6: return LanguageLevel.JDK_1_6;
      case JAVA_7: return LanguageLevel.JDK_1_7;
      case JAVA_8: return LanguageLevel.JDK_1_8;
      case JAVA_9: return LanguageLevel.JDK_1_9;
      case JAVA_10: return LanguageLevel.JDK_10;
      case JAVA_11: return LanguageLevel.JDK_11;
      case JAVA_12: return LanguageLevel.JDK_12;
      case JAVA_X: return LanguageLevel.JDK_X;
      default: throw new IllegalArgumentException("Unhandled ProjectLanguageLevel: " + level);
    }
  }
}
