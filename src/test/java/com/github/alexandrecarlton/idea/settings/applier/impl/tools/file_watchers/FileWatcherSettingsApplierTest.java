package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.*;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.plugins.watcher.model.TaskOptions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileWatcherSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<FileWatcherSettings> settingsApplier;
  private ProjectTasksOptions projectTasksOptions;

  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    projectTasksOptions = ProjectTasksOptions.getInstance(project);
    settingsApplier = new FileWatcherSettingsApplier(projectTasksOptions);
  }

  @Test
  public void basicSettingsApplied() {
    settingsApplier.apply(ImmutableFileWatcherSettings.builder()
      .name("Basic File Watcher")
      .toolToRunOnChanges(ImmutableFileWatcherToolToRunOnChangesSettings.builder()
        .program("/usr/bin/foo")
        .arguments("bar")
        .outputPathsToRefresh("$FilePath$")
        .build())
      .filesToWatch(ImmutableFileWatcherFilesToWatchSettings.builder()
        .fileType(FileWatcherFileType.JAVASCRIPT)
        .scope("Module 'foo'")
        .build())
      .build());

    TaskOptions taskOptions = projectTasksOptions.getTasks()
      .stream()
      .filter(pair -> "Basic File Watcher".equals(pair.first.getName()))
      .findFirst()
      .get()
      .first;
    assertThat(taskOptions.getName()).isEqualTo("Basic File Watcher");
    assertThat(taskOptions.getProgram()).isEqualTo("/usr/bin/foo");
    assertThat(taskOptions.getArguments()).isEqualTo("bar");
    assertThat(taskOptions.getOutput()).isEqualTo("$FilePath$");
    assertThat(taskOptions.getFileExtension()).isEqualTo("js");
    assertThat(taskOptions.getScopeName()).isEqualTo("Module 'foo'");
  }

  @Test
  public void advancedSettingsApplied() {
    settingsApplier.apply(ImmutableFileWatcherSettings.builder()
      .name("Advanced Watcher Settings")
      .toolToRunOnChanges(ImmutableFileWatcherToolToRunOnChangesSettings.builder()
        .program("/usr/bin/foo")
        .arguments("bar")
        .outputPathsToRefresh("$FilePath$")
        .build())
      .filesToWatch(ImmutableFileWatcherFilesToWatchSettings.builder()
        .fileType(FileWatcherFileType.JAVASCRIPT)
        .scope("Module 'foo'")
        .build())
      .advancedOptions(ImmutableFileWatcherAdvancedOptionsSettings.builder()
        .autoSaveEditedFilesToTriggerTheWatcher(true)
        .triggerTheWatcherOnExternalChanges(false)
        .triggerTheWatcherRegardlessOfSyntaxErrors(true)
        .build())
      .build());

    TaskOptions taskOptions = projectTasksOptions.getTasks()
      .stream()
      .filter(pair -> "Advanced Watcher Settings".equals(pair.first.getName()))
      .findFirst()
      .get()
      .first;
    assertThat(taskOptions.isImmediateSync()).isTrue();
    assertThat(taskOptions.isRunOnExternalChanges()).isFalse();
    assertThat(taskOptions.isCheckSyntaxErrors()).isTrue();

  }

}
