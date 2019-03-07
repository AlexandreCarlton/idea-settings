package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.idea.IdeaApplication;
import com.intellij.openapi.application.ApplicationStarter;

public class IdeaSettingsIdeaApplication extends IdeaApplication {

  public IdeaSettingsIdeaApplication(String... args) {
    super(args);
  }

  @Override
  public ApplicationStarter getStarter() {
//    PluginManagerCore.getPlugins(); // used in original getstarter.
    return new IdeaSettingsApplicationStarter();
  }

}
