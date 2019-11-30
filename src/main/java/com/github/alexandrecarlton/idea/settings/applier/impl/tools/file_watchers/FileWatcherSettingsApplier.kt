package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.common.FileTypeMapper
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherAdvancedOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import com.intellij.plugins.watcher.model.TaskOptions
import javax.inject.Inject

class FileWatcherSettingsApplier @Inject
constructor(private val projectTasksOptions: ProjectTasksOptions, private val fileTypeMapper: FileTypeMapper) : SettingsApplier<FileWatcherSettings> {

    override fun apply(settings: FileWatcherSettings) {
        val taskOptions = TaskOptions()
        taskOptions.name = settings.name()
        settings.filesToWatch()
            .fileType()
            .map { fileTypeMapper.mapFileType(it) }
            .map { it.defaultExtension }
            .ifPresent { taskOptions.fileExtension = it }
        settings.filesToWatch()
            .scope()
            .ifPresent { taskOptions.scopeName = it }

        taskOptions.program = settings.toolToRunOnChanges().program()
        taskOptions.arguments = settings.toolToRunOnChanges().arguments()
        taskOptions.output = settings.toolToRunOnChanges().outputPathsToRefresh()

        settings.advancedOptions()
            .ifPresent { advancedOptions -> applyAdvancedOptions(advancedOptions, taskOptions) }

        projectTasksOptions.addTask(taskOptions, true)
    }

    private fun applyAdvancedOptions(settings: FileWatcherAdvancedOptionsSettings, taskOptions: TaskOptions) {
        settings.autoSaveEditedFilesToTriggerTheWatcher().ifPresent { taskOptions.isImmediateSync = it }
        settings.triggerTheWatcherRegardlessOfSyntaxErrors().ifPresent { taskOptions.isCheckSyntaxErrors = it }
        settings.triggerTheWatcherOnExternalChanges().ifPresent { taskOptions.isRunOnExternalChanges = it }
    }
}
