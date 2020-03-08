package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaBlankLinesModule : AbstractPluginModule() {
    @Provides
    fun provideJavaBlankLinesSettingsApplier(applier: Lazy<JavaBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideJavaKeepMaximumBlankLinesSettingsApplier(applier: Lazy<JavaKeepMaximumBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideJavaMinimumBlankLinesSettingsApplier(applier: Lazy<JavaMinimumBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
