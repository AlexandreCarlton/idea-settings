package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot.SpringBootSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaArrangementSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.JavascriptSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects.SqlDialectsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers.FileWatcherSettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import com.intellij.codeInsight.CodeInsightWorkspaceSettings;
import com.intellij.codeInsight.JavaProjectCodeInsightSettings;
import com.intellij.compiler.CompilerConfiguration;
import com.intellij.compiler.CompilerWorkspaceConfiguration;
import com.intellij.execution.RunManager;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.lang.javascript.settings.JSRootConfiguration;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.watcher.model.ProjectTasksOptions;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.sql.dialects.SqlDialectMappings;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;
import org.jetbrains.idea.maven.project.MavenGeneralSettings;

import java.util.function.Supplier;

/**
 * Provides {@link SettingsApplier}s if the necessary plugins are loaded.
 * If the plugins are not loaded, a no-op applier is returned with a warning.
 * <p>
 * We abuse {@link Lazy} to avoid evaluating classes provided by these plugins until they are needed;
 * this way, we will not incur any {@link NoClassDefFoundError}s if the plugins are not loaded.
 */
@Module
public class OptionalSettingsApplierModule {

  private static final Logger LOG = Logger.getInstance(OptionalSettingsApplierModule.class);

  @Provides
  static SettingsApplier<CheckstyleSettings> provideCheckstyleSettingsApplier(
      Project project,
      Lazy<PluginConfigurationManager> pluginConfigurationManager) {
    return provideIfLoaded(Plugin.CHECKSTYLE_IDEA, () -> new CheckstyleSettingsApplier(project, pluginConfigurationManager.get()));
  }

  @Provides
  static SettingsApplier<CompilerSettings> provideCompilerSettingsApplier(Lazy<CompilerConfiguration> compilerConfiguration,
                                                                          Lazy<CompilerWorkspaceConfiguration> compilerWorkspaceConfiguration) {
    return provideIfLoaded(Plugin.JAVA, () -> new CompilerSettingsApplier(compilerConfiguration.get(), compilerWorkspaceConfiguration.get()));
  }

  @Provides
  static SettingsApplier<FileWatcherSettings> provideFileWatcherSettingsApplier(Lazy<ProjectTasksOptions> projectTasksOptions) {
    return provideIfLoaded(Plugin.FILE_WATCHERS, () -> new FileWatcherSettingsApplier(projectTasksOptions.get()));
  }

  @Provides
  static SettingsApplier<JavaArrangementSettings> provideJavaArrangementSettingsApplier(CodeStyleSettings codeStyleSettings) {
    return provideIfLoaded(Plugin.JAVA, () -> new JavaArrangementSettingsApplier(codeStyleSettings));
  }

  @Provides
  static SettingsApplier<JavaAutoImportSettings> provideJavaAutoImportSettingsApplier(CodeInsightWorkspaceSettings codeInsightWorkspaceSettings,
                                                                                      Lazy<JavaProjectCodeInsightSettings> javaProjectCodeInsightSettings) {
    return provideIfLoaded(Plugin.JAVA, () -> new JavaAutoImportSettingsApplier(codeInsightWorkspaceSettings, javaProjectCodeInsightSettings.get()));
  }

  @Provides
  static SettingsApplier<JavaImportsSettings> provideJavaImportsSettingsApplier(CodeStyleSettings codeStyleSettings) {
    return provideIfLoaded(Plugin.JAVA, () -> new JavaImportsSettingsApplier(codeStyleSettings));
  }

  @Provides
  static SettingsApplier<JavascriptSettings> provideJavascriptSettingsApplier(Lazy<JSRootConfiguration> jsRootConfiguration) {
    return provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, () -> new JavascriptSettingsApplier(jsRootConfiguration.get()));
  }

  @Provides
  static SettingsApplier<MavenImportingSettings> provideMavenImportingSettingsApplier(Lazy<org.jetbrains.idea.maven.project.MavenImportingSettings> mavenImportingSettings) {
    return provideIfLoaded(Plugin.MAVEN, () -> new MavenImportingSettingsApplier(mavenImportingSettings.get()));
  }

  @Provides
  static SettingsApplier<MavenSettings> provideMavenSettingsApplier(Lazy<MavenGeneralSettings> mavenGeneralSettings, SettingsApplier<MavenImportingSettings> mavenImportingSettingsApplier) {
    return provideIfLoaded(Plugin.MAVEN, () -> new MavenSettingsApplier(mavenGeneralSettings.get(), mavenImportingSettingsApplier));
  }

  @Provides
  static SettingsApplier<SpringBootSettings> provideSpringBootSettingsApplier(Project project, RunManager runManager) {
    return provideIfLoaded(Plugin.SPRING_BOOT, () -> new SpringBootSettingsApplier(project, runManager));
  }

  @Provides
  static SettingsApplier<SqlDialectsSettings> provideSqlDialectsSettingsApplier(Project project, Lazy<SqlDialectMappings> sqlDialectMappings) {
    return provideIfLoaded(Plugin.DATABASE_TOOLS_AND_SQL, () -> new SqlDialectsSettingsApplier(project, sqlDialectMappings.get()));
  }

  private static <T> SettingsApplier<T> provideIfLoaded(Plugin plugin, Supplier<SettingsApplier<T>> settingsApplierSupplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))
        ? settingsApplierSupplier.get()
        : settings -> LOG.warn("Unable to apply certain settings as plugin '" + plugin.getName() + "' is not installed.");
  }

}
