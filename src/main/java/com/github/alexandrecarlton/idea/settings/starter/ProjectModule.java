package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
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
  static ModuleManager provideModuleManager(Project project) {
    return ModuleManager.getInstance(project);
  }

}
