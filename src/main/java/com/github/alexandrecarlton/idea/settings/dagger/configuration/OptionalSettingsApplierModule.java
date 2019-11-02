package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BuildConfigurationSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.RunMavenGoalSettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class OptionalSettingsApplierModule {

  private static final Logger LOG = Logger.getInstance(OptionalSettingsApplierModule.class);

  @Provides
  static SettingsApplier<RunMavenGoalSettings> provideRunMavenGoalSettingsApplier(Lazy<RunMavenGoalSettingsApplier> runMavenGoalSettingsApplier) {
    return provideIfLoaded(Plugin.MAVEN, runMavenGoalSettingsApplier);
  }

  @Provides
  static SettingsApplier<BuildConfigurationSettings> provideBuildConfigurationSettings(Lazy<BuildConfigurationSettingsApplier> buildConfigurationSettingsApplier) {
    return provideIfLoaded(Plugin.JAVA, buildConfigurationSettingsApplier);
  }

  private static <T> SettingsApplier<T> provideIfLoaded(Plugin plugin, Lazy<? extends SettingsApplier<T>> settingsApplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))
      ? settingsApplier.get()
      : settings -> LOG.warn("Unable to apply certain settings as plugin '" + plugin.getName() + "' is not installed.");
  }
}
