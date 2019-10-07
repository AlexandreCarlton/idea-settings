package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.intellij.ide.plugins.PluginManager;
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

  private static <T> SettingsApplier<T> provideIfLoaded(String pluginId, Supplier<SettingsApplier<T>> settingsApplierSupplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(pluginId))
        ? settingsApplierSupplier.get()
        : settings -> LOG.warn("Unable to apply certain settings as plugin '" + pluginId + "' is not installed.");
  }

}
