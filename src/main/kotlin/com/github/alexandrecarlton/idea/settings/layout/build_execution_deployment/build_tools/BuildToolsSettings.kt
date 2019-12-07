package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings

data class BuildToolsSettings (
    @JsonProperty("Maven")
    val maven: MavenSettings? = null
)
