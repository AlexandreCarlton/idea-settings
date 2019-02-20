package com.github.alexandrecarlton.idea.settings.applier;

import com.github.alexandrecarlton.idea.settings.applier_api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.intellij.openapi.project.Project;

public class IdeaSettingsApplier implements SettingsApplier<IdeaSettings> {

  private final SettingsApplier<EditorSettings> editorSettingsApplier;

  public IdeaSettingsApplier(SettingsApplier<EditorSettings> editorSettingsApplier) {
    this.editorSettingsApplier = editorSettingsApplier;
  }

  public void apply(Project project, IdeaSettings configuration) {
    configuration.editor().ifPresent(editor -> editorSettingsApplier.apply(project, editor));
  }

}
