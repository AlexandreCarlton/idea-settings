package com.github.alexandrecarlton.idea.settings.dialog.common.filetype

import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType.JAVASCRIPT
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType.LESS_STYLE_SHEET
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType.REACT_JSX
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType.TYPESCRIPT
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType.TYPESCRIPT_JSX
import com.intellij.openapi.fileTypes.FileType
import java.util.function.Function
import javax.inject.Inject
import javax.inject.Named

/**
 * Maps our [IdeaFileType] enumeration to an IntelliJ file type.
 * If none can be found, a sentinel value is returned.
 * See [FileTypeModule]
 */
class FileTypeMapper @Inject
constructor(
    @Named("JavaScript") private val javascript: FileType,
    @Named("Less Style Sheet") private val lessStyleSheet: FileType,
    @Named("React JSX") private val reactJsx: FileType,
    @Named("TypeScript") private val typescript: FileType,
    @Named("TypeScript JSX") private val typescriptJsx: FileType
) : Function<IdeaFileType, FileType> {

    override fun apply(fileType: IdeaFileType) =
        when (fileType) {
            JAVASCRIPT -> javascript
            LESS_STYLE_SHEET -> lessStyleSheet
            REACT_JSX -> reactJsx
            TYPESCRIPT -> typescript
            TYPESCRIPT_JSX -> typescriptJsx
        }
}
