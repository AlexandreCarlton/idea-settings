package com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object CheckstyleModule : AbstractPluginModule() {

    @Provides
    internal fun provideCheckstyleSettingsApplier(applier: Lazy<CheckstyleSettingsApplier>) =
        provideIfLoaded(Plugin.CHECKSTYLE_IDEA, applier)
}
