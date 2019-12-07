package com.github.alexandrecarlton.idea.settings.layout.tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings

data class ToolsSettings(
    @JsonProperty("File Watchers")
    val fileWatchers: List<FileWatcherSettings>? = null
)
