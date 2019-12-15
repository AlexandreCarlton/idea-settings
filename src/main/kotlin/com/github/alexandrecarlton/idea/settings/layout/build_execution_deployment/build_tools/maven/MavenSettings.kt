package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class MavenSettings(

    @JsonProperty("Importing")
    val importing: MavenImportingSettings? = null,

    @JsonProperty("Maven home directory")
    // This could be a VirtualFile
    val mavenHomeDirectory: File? = null
)
