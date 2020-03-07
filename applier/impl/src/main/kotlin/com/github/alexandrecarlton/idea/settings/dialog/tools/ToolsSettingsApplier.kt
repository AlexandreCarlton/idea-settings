package com.github.alexandrecarlton.idea.settings.dialog.tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings

import javax.inject.Inject

class ToolsSettingsApplier @Inject
constructor(private val fileWatcherSettingsApplier: SettingsApplier<FileWatcherSettings>) : SettingsApplier<ToolsSettings> {

    override fun apply(settings: ToolsSettings) {
        settings.fileWatchers?.forEach(fileWatcherSettingsApplier::apply)
    }
}
