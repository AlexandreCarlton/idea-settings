package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot.SpringBootSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaArrangementSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript.JavascriptImportsSettingsApplier;
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
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

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
  static SettingsApplier<CheckstyleSettings> provideCheckstyleSettingsApplier(Lazy<CheckstyleSettingsApplier> checkstyleSettingsApplier) {
    return provideIfLoaded(Plugin.CHECKSTYLE_IDEA, checkstyleSettingsApplier);
  }

  @Provides
  static SettingsApplier<CompilerSettings> provideCompilerSettingsApplier(Lazy<CompilerSettingsApplier> compilerSettingsApplier) {
    return provideIfLoaded(Plugin.JAVA, compilerSettingsApplier);
  }

  @Provides
  static SettingsApplier<FileWatcherSettings> provideFileWatcherSettingsApplier(Lazy<FileWatcherSettingsApplier> fileWatcherSettingsApplier) {
    return provideIfLoaded(Plugin.FILE_WATCHERS, fileWatcherSettingsApplier);
  }

  @Provides
  static SettingsApplier<JavaArrangementSettings> provideJavaArrangementSettingsApplier(Lazy<JavaArrangementSettingsApplier> javaArrangementSettingsApplier) {
    return provideIfLoaded(Plugin.JAVA, javaArrangementSettingsApplier);
  }

  @Provides
  static SettingsApplier<JavaAutoImportSettings> provideJavaAutoImportSettingsApplier(Lazy<JavaAutoImportSettingsApplier> javaAutoImportSettingsApplier) {
    return provideIfLoaded(Plugin.JAVA, javaAutoImportSettingsApplier);
  }

  @Provides
  static SettingsApplier<JavaImportsSettings> provideJavaImportsSettingsApplier(Lazy<JavaImportsSettingsApplier> javaImportsSettingsApplier) {
    return provideIfLoaded(Plugin.JAVA, javaImportsSettingsApplier);
  }

  @Provides
  static SettingsApplier<JavascriptImportsSettings> provideJavascriptImportsSettingsApplier(Lazy<JavascriptImportsSettingsApplier> javascriptImportsSettingsApplier) {
    return provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javascriptImportsSettingsApplier);
  }

  @Provides
  static SettingsApplier<JavascriptSettings> provideJavascriptSettingsApplier(Lazy<JavascriptSettingsApplier> javascriptSettingsApplier) {
    return provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javascriptSettingsApplier);
  }

  @Provides
  static SettingsApplier<MavenImportingSettings> provideMavenImportingSettingsApplier(Lazy<MavenImportingSettingsApplier> mavenImportingSettingsApplier) {
    return provideIfLoaded(Plugin.MAVEN, mavenImportingSettingsApplier);
  }

  @Provides
  static SettingsApplier<MavenSettings> provideMavenSettingsApplier(Lazy<MavenSettingsApplier> mavenSettingsApplier) {
    return provideIfLoaded(Plugin.MAVEN, mavenSettingsApplier);
  }

  @Provides
  static SettingsApplier<SpringBootSettings> provideSpringBootSettingsApplier(Lazy<SpringBootSettingsApplier> springBootSettingsApplier) {
    return provideIfLoaded(Plugin.SPRING_BOOT, springBootSettingsApplier);
  }

  @Provides
  static SettingsApplier<SqlDialectsSettings> provideSqlDialectsSettingsApplier(Lazy<SqlDialectsSettingsApplier> sqlDialectsSettingsApplier) {
    return provideIfLoaded(Plugin.DATABASE_TOOLS_AND_SQL, sqlDialectsSettingsApplier);
  }

  private static <T> SettingsApplier<T> provideIfLoaded(Plugin plugin, Lazy<? extends SettingsApplier<T>> settingsApplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))
        ? settingsApplier.get()
        : settings -> LOG.warn("Unable to apply certain settings as plugin '" + plugin.getName() + "' is not installed.");
  }

}
