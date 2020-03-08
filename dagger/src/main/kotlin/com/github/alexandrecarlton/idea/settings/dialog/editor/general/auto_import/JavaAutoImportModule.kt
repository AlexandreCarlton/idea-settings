package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaAutoImportModule : AbstractPluginModule() {

    @Provides
    fun provideJavaAutoImportSettingsApplier(applier: Lazy<JavaAutoImportSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
