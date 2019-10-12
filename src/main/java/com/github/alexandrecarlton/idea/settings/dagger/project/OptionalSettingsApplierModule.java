package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot.SpringBootSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.JavascriptSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.intellij.execution.RunManager;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.lang.javascript.settings.JSRootConfiguration;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;

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
  SettingsApplier<CheckstyleSettings> provideCheckstyleSettingsApplier(
      Project project,
      Lazy<PluginConfigurationManager> pluginConfigurationManager) {
    return provideIfLoaded("CheckStyle-IDEA", () -> new CheckstyleSettingsApplier(project, pluginConfigurationManager.get()));
  }

  @Provides
  SettingsApplier<JavascriptSettings> provideJavascriptSettingsApplier(Lazy<JSRootConfiguration> jsRootConfiguration) {
    return provideIfLoaded("JavaScript", () -> new JavascriptSettingsApplier(jsRootConfiguration.get()));
  }

  @Provides
  SettingsApplier<SpringBootSettings> provideSpringBootSettingsApplier(Project project, RunManager runManager) {
    return provideIfLoaded("com.intellij.spring.boot", () -> new SpringBootSettingsApplier(project, runManager));
  }

  private static <T> SettingsApplier<T> provideIfLoaded(String pluginId, Supplier<SettingsApplier<T>> settingsApplierSupplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(pluginId))
        ? settingsApplierSupplier.get()
        : settings -> LOG.warn("Unable to apply certain settings as plugin '" + pluginId + "' is not installed.");
  }

}
