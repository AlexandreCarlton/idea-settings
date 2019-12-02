package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin
import com.intellij.ide.plugins.PluginManager
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.UnknownFileType
import dagger.Lazy
import dagger.Module
import dagger.Provides
import java.util.function.Supplier
import javax.inject.Named

@Module
object FileTypeModule {

    private val LOG = Logger.getInstance(FileTypeModule::class.java)

    @Provides
    internal fun provideJavaScriptFileType() = JavaScriptFileType.INSTANCE

    @Provides
    @Named("JavaScript")
    internal fun provideJavaScriptFileTypeSupplier(javaScriptFileType: Lazy<JavaScriptFileType>): Supplier<FileType> =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javaScriptFileType)

    private fun provideIfLoaded(plugin: Plugin, fileTypeSupplier: Lazy<out FileType>): Supplier<FileType> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id))) {
            Supplier { fileTypeSupplier.get() }
        } else {
            LOG.warn("Unable to use file type as '" + plugin.pluginName + "' is not installed, using 'Unknown' instead.")
            Supplier { UnknownFileType.INSTANCE }
        }
}
