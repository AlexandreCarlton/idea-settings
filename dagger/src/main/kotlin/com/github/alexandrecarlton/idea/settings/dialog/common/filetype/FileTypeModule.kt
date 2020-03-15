package com.github.alexandrecarlton.idea.settings.dialog.common.filetype

import com.intellij.openapi.fileTypes.FileType
import dagger.Binds
import dagger.Module
import java.util.function.Function

@Module
interface FileTypeModule {

    @Binds
    fun bindFileTypeMapper(mapper: FileTypeMapper): Function<IdeaFileType, FileType>
}
