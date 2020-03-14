package com.github.alexandrecarlton.idea.settings.intellij

import com.intellij.openapi.vfs.LocalFileSystem
import dagger.Module
import dagger.Provides

/**
 * Provides components that are global singletons.
 */
@Module
object IntellijSingletonModule {

    @Provides
    fun provideLocalFileSystem() = LocalFileSystem.getInstance();
}
