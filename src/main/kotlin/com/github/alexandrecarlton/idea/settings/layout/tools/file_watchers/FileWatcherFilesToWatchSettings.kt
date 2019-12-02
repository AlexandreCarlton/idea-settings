package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.layout.common.FileType

data class FileWatcherFilesToWatchSettings(

    val fileType: FileType? = null,

    val scope: String? = null
)
