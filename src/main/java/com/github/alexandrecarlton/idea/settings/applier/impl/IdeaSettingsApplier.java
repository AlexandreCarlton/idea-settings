package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier;
  private final SettingsApplier<EditorSettings> editorSettingsApplier;
  private final SettingsApplier<OtherSettings> otherSettingsApplier;
  private final SettingsApplier<ProjectSettingsSettings> projectSettingsSettingsApplier;

  @Inject
  public IdeaSettingsApplier(SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier,
                             SettingsApplier<EditorSettings> editorSettingsApplier,
                             SettingsApplier<OtherSettings> otherSettingsApplier,
                             SettingsApplier<ProjectSettingsSettings> projectSettingsSettingsApplier) {
    this.buildExecutionDeploymentSettingsApplier = buildExecutionDeploymentSettingsApplier;
    this.editorSettingsApplier = editorSettingsApplier;
    this.otherSettingsApplier = otherSettingsApplier;
    this.projectSettingsSettingsApplier = projectSettingsSettingsApplier;
  }

  public void apply(IdeaSettings settings) {
    settings.buildExecutionDeployment().ifPresent(buildExecutionDeploymentSettingsApplier::apply);
    settings.editor().ifPresent(editorSettingsApplier::apply);
    settings.otherSettings().ifPresent(otherSettingsApplier::apply);
    settings.projectSettings().ifPresent(projectSettingsSettingsApplier::apply);
  }

}
