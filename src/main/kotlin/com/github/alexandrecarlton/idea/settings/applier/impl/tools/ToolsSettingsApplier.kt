package com.github.alexandrecarlton.idea.settings.applier.impl.tools

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings

import javax.inject.Inject

class ToolsSettingsApplier @Inject
constructor(private val fileWatcherSettingsApplier: SettingsApplier<FileWatcherSettings>) : SettingsApplier<ToolsSettings> {

    override fun apply(settings: ToolsSettings) {
        settings.fileWatchers?.forEach(fileWatcherSettingsApplier::apply)
    }
}
