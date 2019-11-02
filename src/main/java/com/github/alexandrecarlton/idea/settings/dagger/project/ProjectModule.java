package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.dagger.configuration.ConfigurationSubcomponent;
import com.github.alexandrecarlton.idea.settings.dagger.module.ModuleSubcomponent;
import com.intellij.application.options.CodeStyle;
import com.intellij.codeInsight.CodeInsightWorkspaceSettings;
import com.intellij.codeInsight.JavaProjectCodeInsightSettings;
import com.intellij.compiler.CompilerConfiguration;
import com.intellij.compiler.CompilerWorkspaceConfiguration;
import com.intellij.execution.RunManager;
import com.intellij.externalDependencies.ExternalDependenciesManager;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.lang.javascript.settings.JSRootConfiguration;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ex.ProjectEx;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import com.intellij.spellchecker.settings.SpellCheckerSettings;
import com.intellij.sql.dialects.SqlDialectMappings;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;
import org.jetbrains.idea.maven.project.MavenGeneralSettings;
import org.jetbrains.idea.maven.project.MavenImportingSettings;
import org.jetbrains.idea.maven.project.MavenProjectsManager;

/**
 * Provides components that depend on the imported {@link Project}.
 */
@Module(subcomponents = {
  ModuleSubcomponent.class,
  ConfigurationSubcomponent.class})
public class ProjectModule {

  @Provides
  static Project provideProject(@Named("project") String path) {
    return ProjectUtil.openOrImport(path, null, false);
  }

  @Provides
  static ProjectEx provideProjectEx(Project project) {
    return (ProjectEx) project;
  }

  @Provides
  static CodeInsightWorkspaceSettings provideCodeInsightWorkspaceSettings(Project project) {
    return CodeInsightWorkspaceSettings.getInstance(project);
  }

  @Provides
  static CodeStyleSettings provideCodeStyleSettings(CodeStyleSettingsManager codeStyleSettingsManager, Project project) {
    // Ensure we only distribute one codeStyleSettings that is mutated in our appliers.
    codeStyleSettingsManager.USE_PER_PROJECT_SETTINGS = true;
    codeStyleSettingsManager.setMainProjectCodeStyle(CodeStyle.getDefaultSettings());
    return CodeStyle.getSettings(project);
  }

  @Provides
  static CodeStyleSettingsManager provideCodeStyleSettingsManager(Project project) {
    return CodeStyleSettingsManager.getInstance(project);
  }

  @Provides
  static CompilerConfiguration provideCompilerConfiguration(Project project) {
    return CompilerConfiguration.getInstance(project);
  }

  @Provides
  static CompilerWorkspaceConfiguration provideCompilerWorkspaceConfiguration(Project project) {
    return CompilerWorkspaceConfiguration.getInstance(project);
  }

  @Provides
  static ExternalDependenciesManager provideExternalDependenciesManager(Project project) {
    return ExternalDependenciesManager.getInstance(project);
  }

  @Provides
  static JavaProjectCodeInsightSettings provideJavaProjectCodeInsightSettings(Project project) {
    return JavaProjectCodeInsightSettings.getSettings(project);
  }

  @Provides
  static JSRootConfiguration provideJSRootConfiguration(Project project) {
    return JSRootConfiguration.getInstance(project);
  }

  @Provides
  static LanguageLevelProjectExtension provideLanguageLevelProjectExtension(Project project) {
    return LanguageLevelProjectExtension.getInstance(project);
  }

  @Provides
  static MavenGeneralSettings provideMavenGeneralSettings(MavenProjectsManager mavenProjectsManager) {
    return mavenProjectsManager.getGeneralSettings();
  }

  @Provides
  static MavenImportingSettings provideMavenImportingSettings(MavenProjectsManager mavenProjectsManager) {
    return mavenProjectsManager.getImportingSettings();
  }

  @Provides
  static MavenProjectsManager provideMavenProjectsManager(Project project) {
    return MavenProjectsManager.getInstance(project);
  }

  @Provides
  static ModuleManager provideModuleManager(Project project) {
    return ModuleManager.getInstance(project);
  }

  @Provides
  static PluginConfigurationManager providePluginConfigurationManager(Project project) {
    return PluginConfigurationManager.getInstance(project);
  }

  @Provides
  static ProjectRootManager provideProjectRootManager(Project project) {
    return ProjectRootManager.getInstance(project);
  }

  @Provides
  static ProjectTasksOptions provideProjectTasksOptions(Project project) {
    return ProjectTasksOptions.getInstance(project);
  }

  @Provides
  static SqlDialectMappings provideSqlDialectMappings(Project project) {
    return SqlDialectMappings.getInstance(project);
  }

  @Provides
  static RunManager provideRunManager(Project project) {
    return RunManager.getInstance(project);
  }

  @Provides
  static SpellCheckerSettings provideSpellCheckerSettings(Project project) {
    return SpellCheckerSettings.getInstance(project);
  }

}
