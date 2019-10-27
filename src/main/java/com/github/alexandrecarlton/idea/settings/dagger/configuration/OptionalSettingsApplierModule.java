package com.github.alexandrecarlton.idea.settings.dagger.configuration;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.BuildConfigurationSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.common.before_launch.RunMavenGoalSettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import dagger.Module;
import dagger.Provides;

import java.util.function.Supplier;

@Module
public class OptionalSettingsApplierModule {

  private static final Logger LOG = Logger.getInstance(OptionalSettingsApplierModule.class);

  @Provides
  static SettingsApplier<RunMavenGoalSettings> provideRunMavenGoalSettingsApplier(RunConfiguration runConfiguration) {
    return provideIfLoaded(Plugin.MAVEN, () -> new RunMavenGoalSettingsApplier(runConfiguration));
  }

  @Provides
  static SettingsApplier<BuildConfigurationSettings> provideBuildConfigurationSettings(RunConfiguration runConfiguration) {
    return provideIfLoaded(Plugin.JAVA, () -> new BuildConfigurationSettingsApplier(runConfiguration));
  }

  private static <T> SettingsApplier<T> provideIfLoaded(Plugin plugin, Supplier<SettingsApplier<T>> settingsApplierSupplier) {
    return PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))
      ? settingsApplierSupplier.get()
      : settings -> LOG.warn("Unable to apply certain settings as plugin '" + plugin.getName() + "' is not installed.");
  }
}
