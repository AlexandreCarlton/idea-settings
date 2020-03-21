package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonProperty

data class BindToSonarQubeSonarCloudSettings(

    @JsonProperty("Bind project to SonarQube / SonarCloud")
    val bindProjectToSonarqubeSonarCloud: Boolean? = null,

    @JsonProperty("Project binding")
    val projectBinding: ProjectBindingSettings? = null
)
