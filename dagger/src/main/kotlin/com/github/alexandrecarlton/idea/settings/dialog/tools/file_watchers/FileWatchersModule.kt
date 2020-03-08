package com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object FileWatchersModule : AbstractPluginModule() {

    @Provides
    fun provideFileWatcherSettingsApplier(applier: Lazy<FileWatcherSettingsApplier>) =
        provideIfLoaded(Plugin.FILE_WATCHERS, applier)
}
