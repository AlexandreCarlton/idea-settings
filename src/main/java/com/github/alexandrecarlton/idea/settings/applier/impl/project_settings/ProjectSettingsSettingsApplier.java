package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.dagger.module.ModuleSubcomponent;
import com.github.alexandrecarlton.idea.settings.dagger.module.ModuleSubcomponent.Builder;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSourceSettings;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleTypeId;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class ProjectSettingsSettingsApplier implements SettingsApplier<ProjectSettingsSettings> {

  private final Project project;
  private final ModuleManager moduleManager;
  private final ModuleSubcomponent.Builder moduleSubcomponentBuilder;
  private final SettingsApplier<ProjectSettings> projectSettingsApplier;

  @Inject
  public ProjectSettingsSettingsApplier(
      Project project, ModuleManager moduleManager,
      Builder moduleSubcomponentBuilder,
      SettingsApplier<ProjectSettings> projectSettingsApplier) {
    this.project = project;
    this.moduleManager = moduleManager;
    this.moduleSubcomponentBuilder = moduleSubcomponentBuilder;
    this.projectSettingsApplier = projectSettingsApplier;
  }

  @Override
  public void apply(ProjectSettingsSettings settings) {
    for (ModuleSettings moduleSettings : settings.modules()) {
      Module module = moduleManager.findModuleByName(moduleSettings.name());
      if (module == null) {
        String dir = moduleSettings.sources()
            .stream()
            .findFirst()
            .map(ModuleSourceSettings::contentRoot)
            .map((project.getBasePath() + "/")::concat)
            .map(d -> d + "/")
            .orElse("");
        module = moduleManager.newModule( dir + moduleSettings.name() + ".iml", ModuleTypeId.JAVA_MODULE);
      }
      ModuleSubcomponent moduleSubcomponent = moduleSubcomponentBuilder.module(module).build();
      moduleSubcomponent.settingsApplier().apply(moduleSettings);
    }
    settings.project().ifPresent(projectSettingsApplier::apply);
  }
}
