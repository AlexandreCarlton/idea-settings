package com.github.alexandrecarlton.idea.settings.dagger.module;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings;
import com.intellij.openapi.module.Module;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * A {@link Subcomponent} that provides objects for a particular {@link Module} of a project.
 */
@Subcomponent(modules = {
    ModuleModule.class,
    SettingsApplierModule.class})
public interface ModuleSubcomponent {

  SettingsApplier<ModuleSettings> settingsApplier();

  @Subcomponent.Builder
  interface Builder {
    @BindsInstance
    Builder module(Module module);
    ModuleSubcomponent build();
  }

}
