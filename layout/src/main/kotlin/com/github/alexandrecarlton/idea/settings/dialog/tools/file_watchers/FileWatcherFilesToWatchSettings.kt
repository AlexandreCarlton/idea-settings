package com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType

data class FileWatcherFilesToWatchSettings(

    @JsonProperty("File type")
    val fileType: IdeaFileType? = null,

    @JsonProperty("Scope")
    val scope: String? = null
)
