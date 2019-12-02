package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven

import java.nio.file.Path

data class MavenSettings(
    val importing: MavenImportingSettings? = null,
    val mavenHomeDirectory: Path? = null
)
