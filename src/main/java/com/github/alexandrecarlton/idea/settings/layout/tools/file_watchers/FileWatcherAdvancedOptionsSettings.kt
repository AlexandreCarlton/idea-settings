package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

data class FileWatcherAdvancedOptionsSettings(

    val autoSaveEditedFilesToTriggerTheWatcher: Boolean? = null,

    val triggerTheWatcherRegardlessOfSyntaxErrors: Boolean? = null,

    val triggerTheWatcherOnExternalChanges: Boolean? = null
)
