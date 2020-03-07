package com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.common.FileTypeMapper
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import com.intellij.plugins.watcher.model.TaskOptions
import javax.inject.Inject

class FileWatcherSettingsApplier @Inject
constructor(private val projectTasksOptions: ProjectTasksOptions, private val fileTypeMapper: FileTypeMapper) : SettingsApplier<FileWatcherSettings> {

    override fun apply(settings: FileWatcherSettings) {
        val taskOptions = TaskOptions()
        taskOptions.name = settings.name
        settings.filesToWatch
            .fileType
            ?.let { fileTypeMapper.mapFileType(it) }
            ?.defaultExtension
            ?.let { taskOptions.fileExtension = it }
        settings.filesToWatch.scope?.let { taskOptions.scopeName = it }

        taskOptions.program = settings.toolToRunOnChanges.program
        taskOptions.arguments = settings.toolToRunOnChanges.arguments
        taskOptions.output = settings.toolToRunOnChanges.outputPathsToRefresh
        settings.toolToRunOnChanges.workingDirectory?.let { taskOptions.workingDir = it }

        settings.advancedOptions?.autoSaveEditedFilesToTriggerTheWatcher?.let { taskOptions.isImmediateSync = it }
        settings.advancedOptions?.triggerTheWatcherRegardlessOfSyntaxErrors?.let { taskOptions.isCheckSyntaxErrors = it.not() }
        settings.advancedOptions?.triggerTheWatcherOnExternalChanges?.let { taskOptions.isRunOnExternalChanges = it }

        projectTasksOptions.addTask(taskOptions, true)
    }
}
