package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.idea.IdeaApplication;
import com.intellij.openapi.application.ApplicationStarter;

public class ImlGenerationIdeaApplication extends IdeaApplication {

  public ImlGenerationIdeaApplication(String... args) {
    super(args);
  }

  @Override
  public ApplicationStarter getStarter() {
//    PluginManagerCore.getPlugins(); // used in original getstarter.
    return new ImlGenerationStarter();
  }

}
