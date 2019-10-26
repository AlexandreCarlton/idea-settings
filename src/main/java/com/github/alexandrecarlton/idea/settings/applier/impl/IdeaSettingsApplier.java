package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier;
  private final SettingsApplier<ConfigurationSettings> configurationsSettingsApplier;
  private final SettingsApplier<EditorSettings> editorSettingsApplier;
  private final SettingsApplier<LanguagesFrameworksSettings> languagesFrameworksSettingsApplier;
  private final SettingsApplier<OtherSettings> otherSettingsApplier;
  private final SettingsApplier<ProjectSettingsSettings> projectSettingsSettingsApplier;
  private final SettingsApplier<ToolsSettings> toolsSettingsApplier;

  @Inject
  public IdeaSettingsApplier(
      SettingsApplier<BuildExecutionDeploymentSettings> buildExecutionDeploymentSettingsApplier,
      SettingsApplier<ConfigurationSettings> configurationsSettingsApplier,
      SettingsApplier<EditorSettings> editorSettingsApplier,
      SettingsApplier<LanguagesFrameworksSettings> languagesFrameworksSettingsApplier,
      SettingsApplier<OtherSettings> otherSettingsApplier,
      SettingsApplier<ProjectSettingsSettings> projectSettingsSettingsApplier,
      SettingsApplier<ToolsSettings> toolsSettingsApplier) {
    this.buildExecutionDeploymentSettingsApplier = buildExecutionDeploymentSettingsApplier;
    this.configurationsSettingsApplier = configurationsSettingsApplier;
    this.editorSettingsApplier = editorSettingsApplier;
    this.languagesFrameworksSettingsApplier = languagesFrameworksSettingsApplier;
    this.otherSettingsApplier = otherSettingsApplier;
    this.projectSettingsSettingsApplier = projectSettingsSettingsApplier;
    this.toolsSettingsApplier = toolsSettingsApplier;
  }

  public void apply(IdeaSettings settings) {
    settings.buildExecutionDeployment().ifPresent(buildExecutionDeploymentSettingsApplier::apply);
    settings.configurations().forEach(configurationsSettingsApplier::apply);
    settings.editor().ifPresent(editorSettingsApplier::apply);
    settings.languagesFrameworks().ifPresent(languagesFrameworksSettingsApplier::apply);
    settings.otherSettings().ifPresent(otherSettingsApplier::apply);
    settings.projectSettings().ifPresent(projectSettingsSettingsApplier::apply);
    settings.tools().ifPresent(toolsSettingsApplier::apply);
  }

}
