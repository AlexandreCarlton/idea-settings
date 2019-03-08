package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.compiler.CompilerConfiguration;
import com.intellij.externalDependencies.ExternalDependenciesManager;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import dagger.Module;
import dagger.Provides;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Provides components that depend on the imported {@link Project}.
 */
@Module
public class ProjectModule {

  @Provides
  @Singleton
  static Project provideProject(@Named("project") String path) {
//    PluginManager.invalidatePlugins();
    Project project = ProjectUtil.openOrImport(path, null, false);
    return project;
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
  static ModuleManager provideModuleManager(Project project) {
    return ModuleManager.getInstance(project);
  }

  @Provides
  static PluginConfigurationManager providePluginConfigurationManager(Project project) {
    return PluginConfigurationManager.getInstance(project);
  }

}
