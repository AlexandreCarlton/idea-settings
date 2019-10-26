package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.remote;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.ImmutableRemoteConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.ImmutableRemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.remote.RemoteConfiguration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<RemoteSettings> settingsApplier;
  private RunManager runManager;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    runManager = RunManager.getInstance(project);
    settingsApplier = new RemoteSettingsApplier(runManager, project);
  }

  @Test
  public void defaultRemoteApplied() {
    settingsApplier.apply(ImmutableRemoteSettings.builder()
        .name("Default Remote")
        .shareThroughVcs(true)
        .build());
    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName("Default Remote");
    assertThat(runnerAndConfigurationSettings).isNotNull();
    assertThat(runnerAndConfigurationSettings.isShared()).isTrue();
  }

  @Test
  public void customRemoteApplied() {
    settingsApplier.apply(ImmutableRemoteSettings.builder()
        .name("Configured Remote")
        .configuration(ImmutableRemoteConfigurationSettings.builder()
            .host("8.8.8.8")
            .port(5000)
            .build())
        .build());
    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName("Configured Remote");
    assertThat(runnerAndConfigurationSettings).isNotNull();
    assertThat(runnerAndConfigurationSettings.getConfiguration()).isInstanceOf(RemoteConfiguration.class);
    RemoteConfiguration remoteConfiguration = (RemoteConfiguration) runnerAndConfigurationSettings.getConfiguration();
    assertThat(remoteConfiguration.HOST).isEqualTo("8.8.8.8");
    assertThat(remoteConfiguration.PORT).isEqualTo("5000");

  }
}
