package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootManager
import dagger.Provides

/**
 * A [dagger.Module] for an IDEA [com.intellij.openapi.module.Module]
 */
@dagger.Module
object ModuleModule {

    @Provides
    fun provideModuleRootManager(module: Module) = ModuleRootManager.getInstance(module)

    @Provides
    fun provideModifiableRootModel(moduleRootManager: ModuleRootManager) = moduleRootManager.modifiableModel
}
