package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier;
  private final SettingsApplier<EditorSettings> editorSettingsApplier;
  private final SettingsApplier<OtherSettings> otherSettingsApplier;

  @Inject
  public IdeaSettingsApplier(SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier,
                             SettingsApplier<EditorSettings> editorSettingsApplier,
                             SettingsApplier<OtherSettings> otherSettingsApplier) {
    this.buildExecutionDeploymentSettingsApplier = buildExecutionDeploymentSettingsApplier;
    this.editorSettingsApplier = editorSettingsApplier;
    this.otherSettingsApplier = otherSettingsApplier;
  }

  public void apply(IdeaSettings configuration) {
    configuration.buildExecutionDeployment().ifPresent(buildExecutionDeploymentSettingsApplier::apply);
    configuration.editor().ifPresent(editorSettingsApplier::apply);
    configuration.otherSettings().ifPresent(otherSettingsApplier::apply);
  }

}
