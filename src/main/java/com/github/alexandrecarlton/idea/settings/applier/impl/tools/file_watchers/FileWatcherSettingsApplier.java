package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherAdvancedOptionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherFileType;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.plugins.watcher.model.TaskOptions;

import javax.inject.Inject;

public class FileWatcherSettingsApplier implements SettingsApplier<FileWatcherSettings> {

  private final ProjectTasksOptions projectTasksOptions;

  @Inject
  public FileWatcherSettingsApplier(ProjectTasksOptions projectTasksOptions) {
    this.projectTasksOptions = projectTasksOptions;
  }

  @Override
  public void apply(FileWatcherSettings settings) {
    TaskOptions taskOptions = new TaskOptions();
    taskOptions.setName(settings.name());
    settings.filesToWatch()
      .fileType()
      .map(this::toExtension)
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

  // TODO: This should return a FileType, and we'd call getExtension on it.
  // But we'll need to be able to dynamically load in plugins for this,
  // e.g. JavaScript -> JavaScriptFileType if we have the extension, otherwise UNKNOWN
  private String toExtension(FileWatcherFileType fileWatcherFileType) {
    switch(fileWatcherFileType) {
      case JAVASCRIPT: return "js";
      default:
        throw new IllegalArgumentException("Unhandled File Watcher File Type: " + fileWatcherFileType);
    }
  }

  private void applyAdvancedOptions(FileWatcherAdvancedOptionsSettings settings, TaskOptions taskOptions) {
    settings.autoSaveEditedFilesToTriggerTheWatcher().ifPresent(taskOptions::setImmediateSync);
    settings.triggerTheWatcherRegardlessOfSyntaxErrors().ifPresent(taskOptions::setCheckSyntaxErrors);
    settings.triggerTheWatcherOnExternalChanges().ifPresent(taskOptions::setRunOnExternalChanges);
  }
}
