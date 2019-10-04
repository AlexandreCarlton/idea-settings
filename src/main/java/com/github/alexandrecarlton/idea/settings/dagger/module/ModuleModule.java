package com.github.alexandrecarlton.idea.settings.dagger.module;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;

import dagger.Provides;

/**
 * A {@link dagger.Module} for an IDEA {@link com.intellij.openapi.module.Module}
 */
@dagger.Module
public class ModuleModule {

  @Provides
  static ModuleRootManager provideModuleRootManager(Module module) {
    return ModuleRootManager.getInstance(module);
  }

  @Provides
  static ModifiableRootModel provideModifiableRootModel(ModuleRootManager moduleRootManager) {
    return moduleRootManager.getModifiableModel();
  }

}
