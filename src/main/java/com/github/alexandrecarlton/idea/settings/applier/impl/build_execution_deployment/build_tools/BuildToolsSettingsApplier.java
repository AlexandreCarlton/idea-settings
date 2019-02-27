package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings;

import javax.inject.Inject;

public class BuildToolsSettingsApplier implements SettingsApplier<BuildToolsSettings> {

  private final SettingsApplier<MavenSettings> mavenSettingsApplier;

  @Inject
  public BuildToolsSettingsApplier(SettingsApplier<MavenSettings> mavenSettingsApplier) {
    this.mavenSettingsApplier = mavenSettingsApplier;
  }

  @Override
  public void apply(BuildToolsSettings settings) {
    settings.maven().ifPresent(mavenSettingsApplier::apply);
  }
}
