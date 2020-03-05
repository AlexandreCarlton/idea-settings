package com.github.alexandrecarlton.idea.settings.module

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootManager
import dagger.Provides

/**
 * A [dagger.Module] for an IDEA [com.intellij.openapi.module.Module]
 */
@dagger.Module
object ModuleModule {

    @Provides
    internal fun provideModuleRootManager(module: Module) = ModuleRootManager.getInstance(module)

    @Provides
    internal fun provideModifiableRootModel(moduleRootManager: ModuleRootManager) = moduleRootManager.modifiableModel
}
