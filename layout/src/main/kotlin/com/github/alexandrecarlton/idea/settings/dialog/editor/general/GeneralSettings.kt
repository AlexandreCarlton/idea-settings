package com.github.alexandrecarlton.idea.settings.dialog.editor.general

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.AutoImportSettings

data class GeneralSettings(
    @JsonProperty("Auto Import")
    val autoImport: AutoImportSettings? = null
)
