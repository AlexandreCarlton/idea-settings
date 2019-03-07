package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.application.ex.ApplicationManagerEx;

import dagger.Module;
import dagger.Provides;

/**
 * Binds isolated singleton instances of IntelliJ IDEA.
 */
@Module
public class IdeaModule {

  @Provides
  static ApplicationEx provideApplicationEx() {
    return ApplicationManagerEx.getApplicationEx();
  }

}
