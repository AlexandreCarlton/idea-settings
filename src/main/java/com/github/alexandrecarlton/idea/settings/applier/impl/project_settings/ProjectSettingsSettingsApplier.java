package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;

import javax.inject.Inject;

public class ProjectSettingsSettingsApplier implements SettingsApplier<ProjectSettingsSettings> {

  private final SettingsApplier<ProjectSettings> projectSettingsApplier;

  @Inject
  public ProjectSettingsSettingsApplier(SettingsApplier<ProjectSettings> projectSettingsApplier) {
    this.projectSettingsApplier = projectSettingsApplier;
  }

  @Override
  public void apply(ProjectSettingsSettings settings) {
    settings.project().ifPresent(projectSettingsApplier::apply);
  }
}
