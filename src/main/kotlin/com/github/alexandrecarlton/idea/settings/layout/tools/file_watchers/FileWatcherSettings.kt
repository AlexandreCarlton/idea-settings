package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

import com.fasterxml.jackson.annotation.JsonProperty

data class FileWatcherSettings(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Files to watch")
    val filesToWatch: FileWatcherFilesToWatchSettings,

    @JsonProperty("Tool to Run on Changes")
    val toolToRunOnChanges: FileWatcherToolToRunOnChangesSettings,

    @JsonProperty("Advanced Options")
    val advancedOptions: FileWatcherAdvancedOptionsSettings? = null
)
