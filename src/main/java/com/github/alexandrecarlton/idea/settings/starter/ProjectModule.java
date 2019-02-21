package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.project.Project;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class ProjectModule {

  @Provides
  @Singleton
  Project provideProject(@Named("project") String path) {
    return ProjectUtil.openOrImport(path, null, false);
  }

}
