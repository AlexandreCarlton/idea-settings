package com.github.alexandrecarlton.idea.settings.dialog.tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers.FileWatcherSettings
import com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.SonarlintSettings
import javax.inject.Inject

class ToolsSettingsApplier @Inject
constructor(
    private val fileWatcherSettingsApplier: SettingsApplier<FileWatcherSettings>,
    private val sonarlintSettingsApplier: SettingsApplier<SonarlintSettings>
) : SettingsApplier<ToolsSettings> {

    override fun apply(settings: ToolsSettings) {
        settings.fileWatchers?.forEach(fileWatcherSettingsApplier::apply)
        settings.sonarlint?.let(sonarlintSettingsApplier::apply)
    }
}
