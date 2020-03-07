package com.github.alexandrecarlton.idea.settings.project

import com.intellij.openapi.vfs.LocalFileSystem
import dagger.Module
import dagger.Provides

/**
 * Provides components that are global singletons.
 */
@Module
object IdeaSingletonModule {

    @Provides
    internal fun provideLocalFileSystem() = LocalFileSystem.getInstance();
}
