package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings.SonarlintProjectSettingsSettings

data class SonarlintSettings(
    @JsonProperty("Project Settings")
    val projectSettings: SonarlintProjectSettingsSettings? = null
)
