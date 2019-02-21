package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final Project project;
  private final SettingsApplier<EditorSettings> editorSettingsApplier;

  @Inject
  public IdeaSettingsApplier(Project project, SettingsApplier<EditorSettings> editorSettingsApplier) {
    this.project = project;
    this.editorSettingsApplier = editorSettingsApplier;
  }

  public void apply(IdeaSettings configuration) {
    configuration.editor().ifPresent(editorSettingsApplier::apply);
    project.save();
  }

}
