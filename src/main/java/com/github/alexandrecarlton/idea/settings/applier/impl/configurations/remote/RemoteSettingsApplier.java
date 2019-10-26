package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.remote;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.remote.RemoteConfiguration;
import com.intellij.execution.remote.RemoteConfigurationType;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class RemoteSettingsApplier implements SettingsApplier<RemoteSettings> {

  private final RunManager runManager;
  private final Project project;

  @Inject
  public RemoteSettingsApplier(RunManager runManager, Project project) {
    this.runManager = runManager;
    this.project = project;
  }

  @Override
  public void apply(RemoteSettings settings) {
    final RemoteConfiguration remoteConfiguration = new RemoteConfiguration(project, new RemoteConfigurationType());
    remoteConfiguration.setName(settings.name());
    settings.configuration()
        .flatMap(RemoteConfigurationSettings::host)
        .ifPresent(host -> { remoteConfiguration.HOST = host; });
    settings.configuration()
        .flatMap(RemoteConfigurationSettings::port)
        .ifPresent(port -> { remoteConfiguration.PORT = Integer.toString(port); });
    final RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.createConfiguration(remoteConfiguration, new RemoteConfigurationType());
    settings.shareThroughVcs().ifPresent(runnerAndConfigurationSettings::setShared);
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }
}
