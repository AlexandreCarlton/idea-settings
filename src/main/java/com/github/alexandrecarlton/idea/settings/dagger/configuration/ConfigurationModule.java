package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.configurations.RunConfiguration;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Named;

@Module
public class ConfigurationModule {

  @Provides
  static RunnerAndConfigurationSettings provideRunnerAndConfigurationSettings(@Named("configuration") String name, RunManager runManager) {
    return runManager.findConfigurationByName(name);
  }

  @Provides
  static List<BeforeRunTask<?>> provideBeforeRunTasks(RunConfiguration runConfiguration) {
    // #getBeforeRunTasks returns the underlying list, not just a copy.
    // If Jetbrains makes the method more robust, we can bind an empty ArrayList<BeforeRunTask<?>>() instead.
    return runConfiguration.getBeforeRunTasks();
  }

  @Provides
  static RunConfiguration provideRunConfiguration(RunnerAndConfigurationSettings runnerAndConfigurationSettings) {
    return runnerAndConfigurationSettings.getConfiguration();
  }

}
