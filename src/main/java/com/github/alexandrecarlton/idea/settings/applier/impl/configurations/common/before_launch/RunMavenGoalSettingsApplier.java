package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings;
import com.intellij.execution.configurations.RunConfiguration;
import org.jetbrains.idea.maven.tasks.MavenBeforeRunTask;

import javax.inject.Inject;

public class RunMavenGoalSettingsApplier implements SettingsApplier<RunMavenGoalSettings> {

  private final RunConfiguration runConfiguration;

  @Inject
  public RunMavenGoalSettingsApplier(RunConfiguration runConfiguration) {
    this.runConfiguration = runConfiguration;
  }

  @Override
  public void apply(RunMavenGoalSettings settings) {
    final MavenBeforeRunTask mavenBeforeRunTask = new MavenBeforeRunTask();
    mavenBeforeRunTask.setGoal(settings.commandLine());
    mavenBeforeRunTask.setProjectPath(settings.workingDirectory().resolve("pom.xml").toString());
    runConfiguration.getBeforeRunTasks().add(mavenBeforeRunTask);
  }
}
