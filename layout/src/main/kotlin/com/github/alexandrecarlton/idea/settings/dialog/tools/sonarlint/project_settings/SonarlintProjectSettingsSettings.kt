package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonProperty

data class SonarlintProjectSettingsSettings(

    @JsonProperty("Bind to SonarQube / SonarCloud")
    val bindToToSonarQubeSonarCloud: BindToSonarQubeSonarCloudSettings? = null

    // File Exclusions

    // Analysis properties

)
