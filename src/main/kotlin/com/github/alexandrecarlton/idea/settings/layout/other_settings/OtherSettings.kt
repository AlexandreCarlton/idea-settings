package com.github.alexandrecarlton.idea.settings.layout.other_settings

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.SaveActionsSettings

data class OtherSettings(
    @JsonProperty("Checkstyle")
    val checkstyle: CheckstyleSettings? = null,

    @JsonProperty("Save Actions")
    val saveActions: SaveActionsSettings? = null
)
