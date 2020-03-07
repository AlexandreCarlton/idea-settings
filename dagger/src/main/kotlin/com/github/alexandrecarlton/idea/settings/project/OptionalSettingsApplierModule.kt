package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.common.Plugin
import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.CompilerSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.application.ApplicationConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerComposeConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerImageConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.remote.RemoteSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.shell_script.ShellScriptConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement.JavaArrangementSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports.JavaImportsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc.JavadocSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript.JavascriptImportsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.JavaAutoImportSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.JavaInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.JavascriptInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.JavascriptSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialectsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle.CheckstyleSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.save_actions.SaveActionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers.FileWatcherSettingsApplier
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import dagger.Lazy
import dagger.Module
import dagger.Provides

/**
 * Provides [SettingsApplier]s if the necessary plugins are loaded.
 * If the plugins are not loaded, a no-op applier is returned with a warning.
 *
 *
 * We abuse [Lazy] to avoid evaluating classes provided by these plugins until they are needed;
 * this way, we will not incur any [NoClassDefFoundError]s if the plugins are not loaded.
 */
@Module
object OptionalSettingsApplierModule {

    private val LOG = Logger.getInstance(OptionalSettingsApplierModule::class.java)

    @Provides
    internal fun bindJavaInspectionsSettingsApplier(javaInspectionSettingsApplier: Lazy<JavaInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaInspectionSettingsApplier)

    @Provides
    internal fun provideJavascriptInspectionsSettingsApplier(javascriptInspectionsSettingsApplier: Lazy<JavascriptInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javascriptInspectionsSettingsApplier)

    private fun <T> provideIfLoaded(plugin: Plugin, settingsApplier: Lazy<out SettingsApplier<T>>): SettingsApplier<T> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id)))
            settingsApplier.get()
        else
            object : SettingsApplier<T> {
                override fun apply(settings: T) {
                    LOG.warn("Unable to apply certain settings as plugin '" + plugin.pluginName + "' is not installed.")
                }
            }
}
