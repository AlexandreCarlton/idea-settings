package com.github.alexandrecarlton.idea.settings.intellij

import com.github.alexandrecarlton.idea.settings.common.Plugin
import com.intellij.ide.plugins.PluginManager
import com.intellij.json.JsonFileType
import com.intellij.lang.ecmascript6.JSXHarmonyFileType
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.lang.javascript.TypeScriptFileType
import com.intellij.lang.javascript.TypeScriptJSXFileType
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.UnknownFileType
import com.intellij.psi.css.CssFileType
import dagger.Module
import dagger.Provides
import org.intellij.plugins.markdown.lang.MarkdownFileType
import org.jetbrains.plugins.less.LESSFileType
import javax.inject.Named

@Module
object IntellijFileTypeModule {

    private val LOG = Logger.getInstance(IntellijFileTypeModule::class.java)

    @Provides
    @Named("Cascading Style Sheet")
    fun provideCascadingStyleSheet() = provideIfLoaded(Plugin.CSS) { CssFileType.INSTANCE }

    @Provides
    @Named("JavaScript")
    fun provideJavascript() = provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT) { JavaScriptFileType.INSTANCE }

    @Provides
    @Named("JSON")
    fun provideJson(): FileType = JsonFileType.INSTANCE

    @Provides
    @Named("Less Style Sheet")
    fun provideLessStyleSheet() = provideIfLoaded(Plugin.LESS) { LESSFileType.LESS }

    @Provides
    @Named("Markdown")
    fun provideMarkdown() = provideIfLoaded(Plugin.MARKDOWN) { MarkdownFileType.INSTANCE }

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
