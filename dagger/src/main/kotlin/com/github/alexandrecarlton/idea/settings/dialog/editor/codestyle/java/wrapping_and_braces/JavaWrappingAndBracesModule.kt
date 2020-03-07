package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaWrappingAndBracesModule : AbstractPluginModule() {
    @Provides
    fun provideJavaWrappingAndBracesSettingsApplier(applier: Lazy<JavaWrappingAndBracesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
