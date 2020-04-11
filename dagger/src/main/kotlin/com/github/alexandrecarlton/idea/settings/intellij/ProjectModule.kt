package com.github.alexandrecarlton.idea.settings.intellij

import com.intellij.ide.impl.ProjectUtil
import com.intellij.openapi.project.Project
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * A module that allows us to open a real project from a provided path.
 */
@Module
object ProjectModule {

    @Provides
    fun provideProject(@Named("project") path: String): Project =
        ProjectUtil.openOrImport(path, null, false)!!
}
