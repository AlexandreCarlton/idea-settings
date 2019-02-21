package com.github.alexandrecarlton.idea.settings.applier.impl.editor;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class EditorSettingsApplier implements SettingsApplier<EditorSettings> {

  private final SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier;

  @Inject
  public EditorSettingsApplier(SettingsApplier<CodeStyleSettings> codeStyleSettingsApplier) {
    this.codeStyleSettingsApplier = codeStyleSettingsApplier;
  }

  public void apply(Project project, EditorSettings configuration) {
    configuration.codeStyle().ifPresent(codeStyle -> codeStyleSettingsApplier.apply(project, codeStyle));
  }
}
