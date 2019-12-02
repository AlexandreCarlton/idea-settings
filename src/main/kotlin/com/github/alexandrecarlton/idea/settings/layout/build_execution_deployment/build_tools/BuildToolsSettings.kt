package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools

import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings

data class BuildToolsSettings (
    val maven: MavenSettings? = null
)
