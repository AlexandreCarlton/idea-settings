package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaCodeStyleModule : AbstractPluginModule() {

    @Provides
    fun provideJavaCodeStyleSettingsApplier(applier: Lazy<JavaCodeStyleSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
