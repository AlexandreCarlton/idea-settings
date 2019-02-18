package com.github.alexandrecarlton.idea.settings.applier;

import com.intellij.openapi.project.Project;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;

public class CodeStyleConfigurer {

  private final JavaConfigurer javaConfigurer;

  public CodeStyleConfigurer(JavaConfigurer javaConfigurer) {
    this.javaConfigurer = javaConfigurer;
  }

  public void configure(Project project, CodeStyleSettings configuration) {
    configuration.java().ifPresent(java -> javaConfigurer.configure(project, java));
  }
}
