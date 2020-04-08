package com.github.alexandrecarlton.idea.settings.common

/**
 * Encapsulates plugins that are (optionally) depended on by idea-settings.
 */
enum class Plugin constructor(val id: String, val pluginName: String) {

    CSS("com.intellij.css", "CSS"),
    CHECKSTYLE_IDEA("CheckStyle-IDEA", "CheckStyle-IDEA"),
    DATABASE_TOOLS_AND_SQL("com.intellij.database", "Database Tools and SQL"),
    DOCKER("Docker", "Docker"),
    FILE_WATCHERS("com.intellij.plugins.watcher", "File Watchers"),
    JAVA("com.intellij.java", "Java"),
    JAVASCRIPT_AND_TYPESCRIPT("JavaScript", "JavaScript and TypeScript"),
    KOTLIN("org.jetbrains.kotlin", "Kotlin"),
    LESS("org.jetbrains.plugins.less", "Less"),
    MARKDOWN("org.intellij.plugins.markdown", "Markdown"),
    MAVEN("org.jetbrains.idea.maven", "Maven"),
    SAVE_ACTIONS("com.dubreuia", "Save Actions"),
    SHELL_SCRIPT("com.jetbrains.sh", "Shell Script"),
    SONARLINT("org.sonarlint.idea", "SonarLint"),
    SPRING_BOOT("com.intellij.spring.boot", "Spring Boot")
}
