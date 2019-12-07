package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven

import com.fasterxml.jackson.annotation.JsonProperty

data class MavenImportingSettings(

    @JsonProperty("Import Maven projects automatically")
    val importMavenProjectsAutomatically: Boolean? = null,

    @JsonProperty("VM options for importer")
    val vmOptionsForImporter: String? = null
)
