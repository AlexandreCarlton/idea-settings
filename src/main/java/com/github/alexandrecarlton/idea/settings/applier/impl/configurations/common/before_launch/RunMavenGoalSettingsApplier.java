package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings;
import com.intellij.execution.BeforeRunTask;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.idea.maven.tasks.MavenBeforeRunTask;

public class RunMavenGoalSettingsApplier implements SettingsApplier<RunMavenGoalSettings> {

  private final List<BeforeRunTask<?>> beforeRunTasks;

  @Inject
  public RunMavenGoalSettingsApplier(List<BeforeRunTask<?>> beforeRunTasks) {
    this.beforeRunTasks = beforeRunTasks;
  }

  @Override
  public void apply(RunMavenGoalSettings settings) {
    final MavenBeforeRunTask mavenBeforeRunTask = new MavenBeforeRunTask();
    mavenBeforeRunTask.setGoal(settings.commandLine());
    mavenBeforeRunTask.setProjectPath(settings.workingDirectory().resolve("pom.xml").toString());
    beforeRunTasks.add(mavenBeforeRunTask);
  }
}
