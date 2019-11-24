package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker.DockerComposeConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker.DockerImageConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script.ShellScriptConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot.SpringBootSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.arrangement.JavaArrangementSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.imports.JavaImportsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc.JavadocSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript.JavascriptImportsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.JavascriptSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects.SqlDialectsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers.FileWatcherSettingsApplier
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin
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
class OptionalSettingsApplierModule {

    private val LOG = Logger.getInstance(OptionalSettingsApplierModule::class.java)

    @Provides
    internal fun provideCheckstyleSettingsApplier(checkstyleSettingsApplier: Lazy<CheckstyleSettingsApplier>) =
        provideIfLoaded(Plugin.CHECKSTYLE_IDEA, checkstyleSettingsApplier)

    @Provides
    internal fun provideCompilerSettingsApplier(compilerSettingsApplier: Lazy<CompilerSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, compilerSettingsApplier)

    @Provides
    internal fun provideDockerComposeConfigurationSettingsApplier(dockerComposeConfigurationSettingsApplier: Lazy<DockerComposeConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.DOCKER, dockerComposeConfigurationSettingsApplier)

    @Provides
    internal fun provideDockerImageConfigurationSettingsApplier(dockerImageConfigurationSettingsApplier: Lazy<DockerImageConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.DOCKER, dockerImageConfigurationSettingsApplier)

    @Provides
    internal fun provideFileWatcherSettingsApplier(fileWatcherSettingsApplier: Lazy<FileWatcherSettingsApplier>) =
        provideIfLoaded(Plugin.FILE_WATCHERS, fileWatcherSettingsApplier)

    @Provides
    internal fun provideJavaArrangementSettingsApplier(javaArrangementSettingsApplier: Lazy<JavaArrangementSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaArrangementSettingsApplier)

    @Provides
    internal fun provideJavaAutoImportSettingsApplier(javaAutoImportSettingsApplier: Lazy<JavaAutoImportSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaAutoImportSettingsApplier)

    @Provides
    internal fun provideJavadocSettingsApplier(javadocSettingsApplier: Lazy<JavadocSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javadocSettingsApplier)

    @Provides
    internal fun provideJavaImportsSettingsApplier(javaImportsSettingsApplier: Lazy<JavaImportsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaImportsSettingsApplier)

    @Provides
    internal fun provideJavaKeepMaximumBlankLinesSettings(javaKeepMaximumBlankLinesSettingsApplier: Lazy<JavaKeepMaximumBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaKeepMaximumBlankLinesSettingsApplier)

    @Provides
    internal fun provideJavaMinimumBlankLinesSettingsApplier(javaMinimumBlankLinesSettingsApplier: Lazy<JavaMinimumBlankLinesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaMinimumBlankLinesSettingsApplier)

    @Provides
    internal fun provideJavaWrappingAndBracesSettingsApplier(javaWrappingAndBracesSettingsApplier: Lazy<JavaWrappingAndBracesSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, javaWrappingAndBracesSettingsApplier)

    @Provides
    internal fun provideJavascriptImportsSettingsApplier(javascriptImportsSettingsApplier: Lazy<JavascriptImportsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javascriptImportsSettingsApplier)

    @Provides
    internal fun provideJavascriptSettingsApplier(javascriptSettingsApplier: Lazy<JavascriptSettingsApplier>) =
        provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javascriptSettingsApplier)

    @Provides
    internal fun provideMavenImportingSettingsApplier(mavenImportingSettingsApplier: Lazy<MavenImportingSettingsApplier>) =
        provideIfLoaded(Plugin.MAVEN, mavenImportingSettingsApplier)

    @Provides
    internal fun provideMavenSettingsApplier(mavenSettingsApplier: Lazy<MavenSettingsApplier>) =
        provideIfLoaded(Plugin.MAVEN, mavenSettingsApplier)

    @Provides
    internal fun provideShellScriptConfigurationSettings(shellScriptConfigurationSettingsApplier: Lazy<ShellScriptConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.SHELL_SCRIPT, shellScriptConfigurationSettingsApplier)

    @Provides
    internal fun provideSpringBootSettingsApplier(springBootSettingsApplier: Lazy<SpringBootSettingsApplier>) =
        provideIfLoaded(Plugin.SPRING_BOOT, springBootSettingsApplier)

    @Provides
    internal fun provideSqlDialectsSettingsApplier(sqlDialectsSettingsApplier: Lazy<SqlDialectsSettingsApplier>) =
        provideIfLoaded(Plugin.DATABASE_TOOLS_AND_SQL, sqlDialectsSettingsApplier)

    private fun <T> provideIfLoaded(plugin: Plugin, settingsApplier: Lazy<out SettingsApplier<T>>): SettingsApplier<T> =
        if (PluginManager.isPluginInstalled(PluginId.findId(plugin.id)))
            settingsApplier.get()
        else
            SettingsApplier { LOG.warn("Unable to apply certain settings as plugin '" + plugin.pluginName + "' is not installed.") }
}
