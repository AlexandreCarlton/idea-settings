package com.github.alexandrecarlton.idea.settings.dialog.common

import com.github.alexandrecarlton.idea.settings.dialog.common.FileType.*
import com.intellij.openapi.fileTypes.FileType
import java.util.function.Supplier
import javax.inject.Inject
import javax.inject.Named

/**
 * Maps our [com.github.alexandrecarlton.idea.settings.dialog.common.FileType] layout to an IntelliJ file type.
 * If none can be found, a sentinel value is returned.
 */
class FileTypeMapper @Inject
constructor(
    @Named("JavaScript") private val javascript: FileType,
    @Named("Less Style Sheet") private val lessStyleSheet: FileType,
    @Named("React JSX") private val reactJsx: FileType,
    @Named("TypeScript") private val typescript: FileType,
    @Named("TypeScript JSX") private val typescriptJsx: FileType
) {
    fun mapFileType(fileType: com.github.alexandrecarlton.idea.settings.dialog.common.FileType) =
        when (fileType) {
            JAVASCRIPT -> javascript
            LESS_STYLE_SHEET -> lessStyleSheet
            REACT_JSX -> reactJsx
            TYPESCRIPT -> typescript
            TYPESCRIPT_JSX -> typescriptJsx
        }
}
