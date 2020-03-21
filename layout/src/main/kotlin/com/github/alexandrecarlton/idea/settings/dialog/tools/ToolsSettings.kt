package com.github.alexandrecarlton.idea.settings.dialog.tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers.FileWatcherSettings
import com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.SonarlintSettings

data class ToolsSettings(
    @JsonProperty("File Watchers")
    val fileWatchers: List<FileWatcherSettings>? = null,

    @JsonProperty("SonarLint")
    val sonarlint: SonarlintSettings? = null
)
