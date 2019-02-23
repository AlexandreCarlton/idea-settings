package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.compiler.CompilerConfiguration;
import com.intellij.externalDependencies.ExternalDependenciesManager;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class ProjectModule {

  @Provides
  @Singleton
  static Project provideProject(@Named("project") String path) {
    return ProjectUtil.openOrImport(path, null, false);
  }

  @Provides
  @Singleton
  static CompilerConfiguration provideCompilerConfiguration(Project project) {
    return CompilerConfiguration.getInstance(project);
  }

  @Provides
  @Singleton
  static ExternalDependenciesManager provideExternalDependenciesManager(Project project) {
    return ExternalDependenciesManager.getInstance(project);
  }

  @Provides
  @Singleton
  static ModuleManager provideModuleManager(Project project) {
    return ModuleManager.getInstance(project);
  }

}
