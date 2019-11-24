package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.common.FileTypeMapper;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.common.FileType;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherAdvancedOptionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherFilesToWatchSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherToolToRunOnChangesSettings;
import com.intellij.lang.javascript.JavaScriptFileType;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.plugins.watcher.model.TaskOptions;
import org.junit.Before;
import org.junit.Test;

public class FileWatcherSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<FileWatcherSettings> settingsApplier;
  private ProjectTasksOptions projectTasksOptions;
  private FileTypeMapper fileTypeMapper;

  @Before
  public void setUp() {
    fileTypeMapper = mock(FileTypeMapper.class);
    projectTasksOptions = ProjectTasksOptions.getInstance(project);
    settingsApplier = new FileWatcherSettingsApplier(projectTasksOptions, fileTypeMapper);
  }

  @Test
  public void basicSettingsApplied() {
    when(fileTypeMapper.mapFileType(FileType.JAVASCRIPT)).thenReturn(JavaScriptFileType.INSTANCE);

    settingsApplier.apply(ImmutableFileWatcherSettings.builder()
      .name("Basic File Watcher")
      .toolToRunOnChanges(ImmutableFileWatcherToolToRunOnChangesSettings.builder()
          .program("/usr/bin/foo")
          .arguments("bar")
          .outputPathsToRefresh("$FilePath$")
          .build())
      .filesToWatch(ImmutableFileWatcherFilesToWatchSettings.builder()
          .fileType(FileType.JAVASCRIPT)
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
        .fileType(FileType.JAVASCRIPT)
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
