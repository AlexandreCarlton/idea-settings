package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.configurations.RunConfiguration;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class ConfigurationModule {

  @Provides
  static RunnerAndConfigurationSettings provideRunnerAndConfigurationSettings(@Named("configuration") String name, RunManager runManager) {
    return runManager.findConfigurationByName(name);
  }

  @Provides
  static RunConfiguration provideRunConfiguration(RunnerAndConfigurationSettings runnerAndConfigurationSettings) {
    return runnerAndConfigurationSettings.getConfiguration();
  }

}
