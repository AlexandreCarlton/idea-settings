package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings;

import javax.inject.Inject;

public class MavenImportingSettingsApplier implements SettingsApplier<MavenImportingSettings> {

  private final org.jetbrains.idea.maven.project.MavenImportingSettings mavenImportingSettings;

  @Inject
  public MavenImportingSettingsApplier(org.jetbrains.idea.maven.project.MavenImportingSettings mavenImportingSettings) {
    this.mavenImportingSettings = mavenImportingSettings;
  }

  @Override
  public void apply(MavenImportingSettings settings) {
    // Setting this to true causes IntelliJ IDEA to hang.
    // The method itself fires off listeners, but even if we set this reflectively, it still
    // prevents us from shutting down.
    // settings.importMavenProjectsAutomatically().ifPresent(mavenImportingSettings::setImportAutomatically);
    settings.vmOptionsForImporter().ifPresent(mavenImportingSettings::setVmOptionsForImporter);
  }
}
