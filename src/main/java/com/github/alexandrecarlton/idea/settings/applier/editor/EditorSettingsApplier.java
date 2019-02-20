package com.github.alexandrecarlton.idea.settings.applier.editor;

import com.github.alexandrecarlton.idea.settings.applier_api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.intellij.openapi.project.Project;

public class EditorSettingsApplier implements SettingsApplier<EditorSettings> {

  private final SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier;

  public EditorSettingsApplier(SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier) {
    this.codeStyleSettingsApplier = codeStyleSettingsApplier;
  }

  public void apply(Project project, EditorSettings configuration) {
    configuration.codeStyle().ifPresent(codeStyle -> codeStyleSettingsApplier.apply(project, codeStyle));
  }
}
