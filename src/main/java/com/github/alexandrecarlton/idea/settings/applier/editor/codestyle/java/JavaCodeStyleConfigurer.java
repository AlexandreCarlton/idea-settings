package com.github.alexandrecarlton.idea.settings.applier.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.intellij.openapi.project.Project;

// JavaCodestyleConifugrer
public class JavaCodeStyleConfigurer {

  private final JavaImportsConfigurer javaImportsConfigurer;

  public JavaCodeStyleConfigurer(JavaImportsConfigurer javaImportsConfigurer) {
    this.javaImportsConfigurer = javaImportsConfigurer;
  }

  public void configure(Project project, JavaCodeStyleSettings java) {
    java.imports().ifPresent(imports -> javaImportsConfigurer.configure(project, imports));
  }
}
