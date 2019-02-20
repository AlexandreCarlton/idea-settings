package com.github.alexandrecarlton.idea.settings.applier.editor;

import com.github.alexandrecarlton.idea.settings.applier.editor.codestyle.CodeStyleConfigurer;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.intellij.openapi.project.Project;

public class EditorConfigurer {

  private final CodeStyleConfigurer codeStyleConfigurer;

  public EditorConfigurer(CodeStyleConfigurer codeStyleConfigurer) {
    this.codeStyleConfigurer = codeStyleConfigurer;
  }

  public void configure(Project project, EditorSettings configuration) {
    configuration.codeStyle().ifPresent(codeStyle -> codeStyleConfigurer.configure(project, codeStyle));
  }
}
