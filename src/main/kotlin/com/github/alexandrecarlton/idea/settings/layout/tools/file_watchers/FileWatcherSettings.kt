package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

data class FileWatcherSettings(

    val name: String,

    val filesToWatch: FileWatcherFilesToWatchSettings,

    val toolToRunOnChanges: FileWatcherToolToRunOnChangesSettings,

    val advancedOptions: FileWatcherAdvancedOptionsSettings? = null
)
