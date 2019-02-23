package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final Project project;
  private final SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier;
  private final SettingsApplier<EditorSettings> editorSettingsApplier;

  @Inject
  public IdeaSettingsApplier(Project project,
                             SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier,
                             SettingsApplier<EditorSettings> editorSettingsApplier) {
    this.project = project;
    this.buildExecutionDeploymentSettingsApplier = buildExecutionDeploymentSettingsApplier;
    this.editorSettingsApplier = editorSettingsApplier;
  }

  public void apply(IdeaSettings configuration) {
    configuration.buildExecutionDeployment().ifPresent(buildExecutionDeploymentSettingsApplier::apply);
    configuration.editor().ifPresent(editorSettingsApplier::apply);
    project.save();
  }

}
