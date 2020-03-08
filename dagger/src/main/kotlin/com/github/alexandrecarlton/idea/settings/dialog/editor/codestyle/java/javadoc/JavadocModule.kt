package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavadocModule : AbstractPluginModule() {
    @Provides
    fun provideJavadocSettingsApplier(applier: Lazy<JavadocSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
