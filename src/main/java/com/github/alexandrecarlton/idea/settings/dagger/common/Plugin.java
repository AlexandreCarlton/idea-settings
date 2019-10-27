package com.github.alexandrecarlton.idea.settings.dagger.common;

/**
 * Encapsulates plugins that are (optionally) depended on by idea-settings.
 */
public enum Plugin {

  CHECKSTYLE_IDEA("CheckStyle-IDEA", "CheckStyle-IDEA"),
  DATABASE_TOOLS_AND_SQL("com.intellij.database", "Database Tools and SQL"),
  FILE_WATCHERS("com.intellij.plugins.watcher", "File Watchers"),
  JAVA("com.intellij.java", "Java"),
  JAVASCRIPT_AND_TYPESCRIPT("JavaScript", "JavaScript and TypeScript"),
  MAVEN("org.jetbrains.idea.maven", "Maven"),
  SPRING_BOOT("com.intellij.spring.boot", "Spring Boot");

  private final String id;
  private final String name;

  Plugin(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
