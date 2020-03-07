package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaImportsModule : AbstractPluginModule() {
    @Provides
    internal fun provideJavaImportsSettingsApplier(applier: Lazy<JavaImportsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
