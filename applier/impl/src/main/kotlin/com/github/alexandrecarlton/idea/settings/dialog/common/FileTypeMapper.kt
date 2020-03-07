package com.github.alexandrecarlton.idea.settings.dialog.common

import com.github.alexandrecarlton.idea.settings.dialog.common.FileType.JAVASCRIPT
import com.intellij.openapi.fileTypes.FileType
import java.util.function.Supplier
import javax.inject.Inject
import javax.inject.Named

/**
 * Maps our [FileType] layout to an IntelliJ file type.
 * If none can be found, a sentinel value is returned.
 */
class FileTypeMapper @Inject
constructor(@param:Named("JavaScript") private val javascriptFileTypeSupplier: Supplier<FileType>) {

    fun mapFileType(fileType: com.github.alexandrecarlton.idea.settings.dialog.common.FileType) =
        when (fileType) {
            JAVASCRIPT -> javascriptFileTypeSupplier.get()
        }
}
