package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.common.FileType

data class FileWatcherFilesToWatchSettings(

    @JsonProperty("File type")
    val fileType: FileType? = null,

    @JsonProperty("Scope")
    val scope: String? = null
)
