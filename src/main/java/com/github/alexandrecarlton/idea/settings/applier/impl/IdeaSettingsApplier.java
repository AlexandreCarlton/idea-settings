package com.github.alexandrecarlton.idea.settings.applier.impl;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final SettingsApplier<EditorSettings> editorSettingsApplier;

  @Inject
  public IdeaSettingsApplier(SettingsApplier<EditorSettings> editorSettingsApplier) {
    this.editorSettingsApplier = editorSettingsApplier;
  }

  public void apply(Project project, IdeaSettings configuration) {
    configuration.editor().ifPresent(editor -> editorSettingsApplier.apply(project, editor));
  }

}
