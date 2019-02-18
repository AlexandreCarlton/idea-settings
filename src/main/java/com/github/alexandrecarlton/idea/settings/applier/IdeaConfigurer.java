package com.github.alexandrecarlton.idea.settings.applier;

import com.github.alexandrecarlton.idea.settings.applier.editor.EditorConfigurer;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.intellij.openapi.project.Project;

public class IdeaConfigurer {

  private final EditorConfigurer editorConfigurer;

  public IdeaConfigurer(EditorConfigurer editorConfigurer) {
    this.editorConfigurer = editorConfigurer;
  }

  public void configure(Project project, IdeaSettings configuration) {
    configuration.editor().ifPresent(editor -> editorConfigurer.configure(project, editor));
  }

}
