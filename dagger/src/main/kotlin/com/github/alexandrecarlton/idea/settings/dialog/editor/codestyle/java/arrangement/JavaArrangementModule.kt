package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaArrangementModule : AbstractPluginModule() {
    @Provides
    fun provideJavaArrangementSettingsApplier(applier: Lazy<JavaArrangementSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
