package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;

import javax.inject.Inject;

public class MavenImportingSettingsApplier implements SettingsApplier<MavenImportingSettings> {

  @Inject
  public MavenImportingSettingsApplier() {
  }

  @Override
  public void apply(MavenImportingSettings settings) {
    // A no-op for now until we sort out IDEA's plugin loading.
  }
}
