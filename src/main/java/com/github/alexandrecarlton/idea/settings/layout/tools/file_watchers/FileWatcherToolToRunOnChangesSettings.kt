package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

data class FileWatcherToolToRunOnChangesSettings(
    val program: String,

    val arguments: String,

    val outputPathsToRefresh: String
)
