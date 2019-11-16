package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.common.FileTypeMapper;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherAdvancedOptionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.plugins.watcher.model.TaskOptions;
import javax.inject.Inject;

public class FileWatcherSettingsApplier implements SettingsApplier<FileWatcherSettings> {

  private final ProjectTasksOptions projectTasksOptions;
  private final FileTypeMapper fileTypeMapper;

  @Inject
  public FileWatcherSettingsApplier(ProjectTasksOptions projectTasksOptions, FileTypeMapper fileTypeMapper) {
    this.projectTasksOptions = projectTasksOptions;
    this.fileTypeMapper = fileTypeMapper;
  }

  @Override
  public void apply(FileWatcherSettings settings) {
    TaskOptions taskOptions = new TaskOptions();
    taskOptions.setName(settings.name());
    settings.filesToWatch()
        .fileType()
        .map(fileTypeMapper::mapFileType)
        .map(FileType::getDefaultExtension)
        .ifPresent(taskOptions::setFileExtension);
    settings.filesToWatch()
        .scope()
        .ifPresent(taskOptions::setScopeName);

    taskOptions.setProgram(settings.toolToRunOnChanges().program());
    taskOptions.setArguments(settings.toolToRunOnChanges().arguments());
    taskOptions.setOutput(settings.toolToRunOnChanges().outputPathsToRefresh());

    settings.advancedOptions()
      .ifPresent(advancedOptions -> applyAdvancedOptions(advancedOptions, taskOptions));

    projectTasksOptions.addTask(taskOptions, true);
  }

  private void applyAdvancedOptions(FileWatcherAdvancedOptionsSettings settings, TaskOptions taskOptions) {
    settings.autoSaveEditedFilesToTriggerTheWatcher().ifPresent(taskOptions::setImmediateSync);
    settings.triggerTheWatcherRegardlessOfSyntaxErrors().ifPresent(taskOptions::setCheckSyntaxErrors);
    settings.triggerTheWatcherOnExternalChanges().ifPresent(taskOptions::setRunOnExternalChanges);
  }
}
