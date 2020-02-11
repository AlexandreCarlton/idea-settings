package com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions

import com.fasterxml.jackson.annotation.JsonProperty

data class GeneralSaveActionsSettings(

    @JsonProperty("Activate save actions on save (before saving each file, performs the configured actions below)")
    val activateSaveActionsOnSave: Boolean? = null,

    @JsonProperty("Activate save actions on shortcut (default \"CTRL + SHIFT + S\")")
    val activateSaveActionsOnShortcut: Boolean? = null,

    @JsonProperty("Activate save actions on batch (\"Code > Save Actions > Execute on multiple files\")")
    val activateSaveActionsOnBatch: Boolean? = null,

    @JsonProperty("No action if compile errors (applied per file)")
    val noActionIfCompileErrors: Boolean? = null
)
