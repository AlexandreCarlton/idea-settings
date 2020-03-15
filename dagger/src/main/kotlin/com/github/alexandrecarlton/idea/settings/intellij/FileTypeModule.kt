package com.github.alexandrecarlton.idea.settings.intellij

import com.github.alexandrecarlton.idea.settings.common.Plugin
import com.intellij.ide.plugins.PluginManager
import com.intellij.lang.ecmascript6.JSXHarmonyFileType
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.lang.javascript.TypeScriptFileType
import com.intellij.lang.javascript.TypeScriptJSXFileType
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.UnknownFileType
import dagger.Module
import dagger.Provides
import org.jetbrains.plugins.less.LESSFileType
import javax.inject.Named

@Module
object FileTypeModule {

    private val LOG = Logger.getInstance(FileTypeModule::class.java)

    @Provides
    @Named("JavaScript")
    fun provideJavascript() = provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT) { JavaScriptFileType.INSTANCE }

    @Provides
    @Named("Less Style Sheet")
    fun provideLessStyleSheet() = provideIfLoaded(Plugin.LESS) { LESSFileType.LESS }

    @Provides
    @Named("React JSX")
    fun provideReactJsx() = provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT) { JSXHarmonyFileType.INSTANCE }

    @Provides
    @Named("TypeScript")
    fun provideTypescript() = provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT) { TypeScriptFileType.INSTANCE }

    @Provides
    @Named("TypeScript JSX")
    fun provideTypescriptJsx() = provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT) { TypeScriptJSXFileType.INSTANCE }

    private fun provideIfLoaded(plugin: Plugin, supplier: () -> FileType): FileType =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id))) {
            supplier()
        } else {
            LOG.warn("Unable to use file type as '${plugin.pluginName}' is not installed, using 'Unknown' instead.")
            UnknownFileType.INSTANCE
        }
}
