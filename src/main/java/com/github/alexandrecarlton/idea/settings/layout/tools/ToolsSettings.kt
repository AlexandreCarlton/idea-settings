package com.github.alexandrecarlton.idea.settings.layout.tools

import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings

data class ToolsSettings(
    val fileWatchers: List<FileWatcherSettings>? = null
)
