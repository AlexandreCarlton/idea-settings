package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment

import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.CompilerSettings

data class BuildExecutionDeploymentSettings(
    val buildTools: BuildToolsSettings? = null,
    val compiler: CompilerSettings? = null,
    val requiredPlugins: List<RequiredPlugin>? = null
)
