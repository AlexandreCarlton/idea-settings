package com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import

data class JavaAutoImportSettings(

    val optimizeImportsOnTheFly: Boolean? = null,

    val excludeFromImportAndCompletion: List<String>? = null
)
