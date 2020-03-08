package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideJavaInspectionsSettingsApplier(applier: Lazy<JavaInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
