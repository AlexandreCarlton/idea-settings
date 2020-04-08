package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object KotlinAutoImportModule : AbstractPluginModule() {

    @Provides
    fun provideKotlinAutoImportSettingsApplier(applier: Lazy<KotlinAutoImportSettingsApplier>) =
        provideIfLoaded(Plugin.KOTLIN, applier)
}
