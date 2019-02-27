package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;

import javax.inject.Inject;

public class MavenSettingsApplier implements SettingsApplier<MavenSettings> {

  private final SettingsApplier<MavenImportingSettings> mavenImportingSettingsApplier;

  @Inject
  public MavenSettingsApplier(SettingsApplier<MavenImportingSettings> mavenImportingSettingsApplier) {
    this.mavenImportingSettingsApplier = mavenImportingSettingsApplier;
  }

  @Override
  public void apply(MavenSettings settings) {
    settings.importing().ifPresent(mavenImportingSettingsApplier::apply);
  }
}
