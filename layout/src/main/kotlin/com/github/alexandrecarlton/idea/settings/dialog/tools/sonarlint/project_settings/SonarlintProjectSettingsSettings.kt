package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonProperty

data class SonarlintProjectSettingsSettings(

    @JsonProperty("Bind to SonarQube / SonarCloud")
    val bindToToSonarQubeSonarCloud: BindToSonarQubeSonarCloudSettings? = null,

    @JsonProperty("File Exclusions")
    val fileExclusions: List<SonarlintFileExclusion>? = null,

    @JsonProperty("Analysis properties")
    val analysisProperties: List<SonarlintAnalysisProperty>? = null

)
