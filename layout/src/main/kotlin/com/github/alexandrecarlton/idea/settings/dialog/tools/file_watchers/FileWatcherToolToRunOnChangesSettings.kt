package com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers

import com.fasterxml.jackson.annotation.JsonProperty

data class FileWatcherToolToRunOnChangesSettings(

    @JsonProperty("Program")
    val program: String,

    @JsonProperty("Arguments")
    val arguments: String,

    @JsonProperty("Output paths to refresh")
    val outputPathsToRefresh: String,

    @JsonProperty("Working directory")
    val workingDirectory: String? = null
)
