package com.github.alexandrecarlton.idea.settings.applier.editor.codestyle;

import com.github.alexandrecarlton.idea.settings.applier.editor.codestyle.java.JavaCodeStyleConfigurer;
import com.intellij.openapi.project.Project;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;

public class CodeStyleConfigurer {

  private final JavaCodeStyleConfigurer javaCodeStyleConfigurer;

  public CodeStyleConfigurer(JavaCodeStyleConfigurer javaCodeStyleConfigurer) {
    this.javaCodeStyleConfigurer = javaCodeStyleConfigurer;
  }

  public void configure(Project project, CodeStyleSettings configuration) {
    configuration.java().ifPresent(java -> javaCodeStyleConfigurer.configure(project, java));
  }
}
