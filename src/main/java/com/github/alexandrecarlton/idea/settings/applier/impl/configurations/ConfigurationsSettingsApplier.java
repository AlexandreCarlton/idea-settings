package com.github.alexandrecarlton.idea.settings.applier.impl.configurations;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.configuration.ConfigurationSubcomponent;
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import java.util.ArrayList;
import java.util.Collections;
import javax.inject.Inject;

public class ConfigurationsSettingsApplier implements SettingsApplier<ConfigurationSettings> {

  private final RunManager runManager;
  private final ConfigurationSubcomponent.Builder configurationSubcomponentBuilder;
  private final SettingsApplier<DockerComposeConfigurationSettings> dockerComposeConfigurationSettingsApplier;
  private final SettingsApplier<DockerImageConfigurationSettings> dockerImageConfigurationSettingsApplier;
  private final SettingsApplier<RemoteSettings> remoteConfigurationApplier;
  private final SettingsApplier<ShellScriptConfigurationSettings> shellScriptConfigurationSettingsApplier;
  private final SettingsApplier<SpringBootSettings> springBootConfigurationApplier;

  @Inject
  public ConfigurationsSettingsApplier(RunManager runManager,
                                       ConfigurationSubcomponent.Builder configurationSubcomponentBuilder,
                                       SettingsApplier<DockerComposeConfigurationSettings> dockerComposeConfigurationSettingsApplier, SettingsApplier<DockerImageConfigurationSettings> dockerImageConfigurationSettingsApplier,
                                       SettingsApplier<RemoteSettings> remoteConfigurationApplier,
                                       SettingsApplier<ShellScriptConfigurationSettings> shellScriptConfigurationSettingsApplier,
                                       SettingsApplier<SpringBootSettings> springBootConfigurationApplier) {
    this.runManager = runManager;
    this.configurationSubcomponentBuilder = configurationSubcomponentBuilder;
    this.dockerComposeConfigurationSettingsApplier = dockerComposeConfigurationSettingsApplier;
    this.dockerImageConfigurationSettingsApplier = dockerImageConfigurationSettingsApplier;
    this.remoteConfigurationApplier = remoteConfigurationApplier;
    this.shellScriptConfigurationSettingsApplier = shellScriptConfigurationSettingsApplier;
    this.springBootConfigurationApplier = springBootConfigurationApplier;
  }

  @Override
  public void apply(ConfigurationSettings settings) {
    if (settings instanceof DockerComposeConfigurationSettings) {
      dockerComposeConfigurationSettingsApplier.apply((DockerComposeConfigurationSettings) settings);
    } else if (settings instanceof DockerImageConfigurationSettings) {
      dockerImageConfigurationSettingsApplier.apply((DockerImageConfigurationSettings) settings);
    } else if (settings instanceof RemoteSettings) {
      remoteConfigurationApplier.apply((RemoteSettings) settings);
    } else if (settings instanceof ShellScriptConfigurationSettings) {
      shellScriptConfigurationSettingsApplier.apply((ShellScriptConfigurationSettings) settings);
    } else if (settings instanceof SpringBootSettings) {
      springBootConfigurationApplier.apply((SpringBootSettings) settings);
    } else {
      throw new IllegalArgumentException("Unhandled settings " + settings);
    }

    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName(settings.name());
    if (runnerAndConfigurationSettings == null) {
      return;
    }
    settings.beforeLaunch().ifPresent(tasks -> runnerAndConfigurationSettings.getConfiguration().setBeforeRunTasks(new ArrayList<>()));
    ConfigurationSubcomponent configurationSubcomponent = configurationSubcomponentBuilder
        .configuration(settings.name())
        .build();
    settings.beforeLaunch()
      .orElse(Collections.emptyList())
      .forEach(configurationSubcomponent.beforeLaunchConfigurationSettingsApplier()::apply);

    runnerAndConfigurationSettings.getConfiguration()
        .getBeforeRunTasks()
        .forEach(task -> task.setEnabled(true));

    // To share through VCS we need to re-add the configuration.
    settings.shareThroughVcs().ifPresent(runnerAndConfigurationSettings::setShared);
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }

}
