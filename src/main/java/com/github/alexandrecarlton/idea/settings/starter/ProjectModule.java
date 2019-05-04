package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.compiler.CompilerConfiguration;
import com.intellij.externalDependencies.ExternalDependenciesManager;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ex.ProjectEx;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.openapi.roots.ProjectRootManager;
import dagger.Module;
import dagger.Provides;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;

import javax.inject.Named;

/**
 * Provides components that depend on the imported {@link Project}.
 */
@Module
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
  static CompilerConfiguration provideCompilerConfiguration(Project project) {
    return CompilerConfiguration.getInstance(project);
  }

  @Provides
  static ExternalDependenciesManager provideExternalDependenciesManager(Project project) {
    return ExternalDependenciesManager.getInstance(project);
  }

  @Provides
  static LanguageLevelProjectExtension provideLanguageLevelProjectExtension(Project project) {
    return LanguageLevelProjectExtension.getInstance(project);
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

}
