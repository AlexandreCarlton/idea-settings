package com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions

import com.fasterxml.jackson.annotation.JsonProperty

data class SaveActionsSettings(
    @JsonProperty("General")
    val general: GeneralSaveActionsSettings? = null,

    @JsonProperty("Formatting Actions")
    val formattingActions: FormattingActionsSettings? = null,

    @JsonProperty("Java inspection and quick fix")
    val javaInspectionAndQuickFix: JavaInspectionAndQuickFixSettings? = null
)
