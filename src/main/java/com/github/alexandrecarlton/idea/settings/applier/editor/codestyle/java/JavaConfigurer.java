package com.github.alexandrecarlton.idea.settings.applier;

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaSettings;
import com.intellij.openapi.project.Project;

public class JavaConfigurer {

  private final ImportsConfigurer importsConfigurer;

  public JavaConfigurer(ImportsConfigurer importsConfigurer) {
    this.importsConfigurer = importsConfigurer;
  }

  public void configure(Project project, JavaSettings java) {
    java.imports().ifPresent(imports -> importsConfigurer.configure(project, imports));
  }
}
