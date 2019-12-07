package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

import com.fasterxml.jackson.annotation.JsonProperty

data class FileWatcherAdvancedOptionsSettings(

    @JsonProperty("Auto-save edited files to trigger the watcher")
    val autoSaveEditedFilesToTriggerTheWatcher: Boolean? = null,

    @JsonProperty("Trigger the watcher regardless of syntax errors")
    val triggerTheWatcherRegardlessOfSyntaxErrors: Boolean? = null,

    @JsonProperty("Trigger the watcher on external changes")
    val triggerTheWatcherOnExternalChanges: Boolean? = null
)
