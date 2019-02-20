package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.idea.IdeaApplication;
import com.intellij.openapi.application.ApplicationStarter;

public class ImlGenerationIdeaApplication extends IdeaApplication {

  public ImlGenerationIdeaApplication(String... args) {
    super(args);
  }

  @Override
  public ApplicationStarter getStarter() {
    return new ImlGenerationStarter();
  }

}
