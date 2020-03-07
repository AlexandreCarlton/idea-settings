package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.CompilerSettings

data class BuildExecutionDeploymentSettings(

    @JsonProperty("Build Tools")
    val buildTools: BuildToolsSettings? = null,

    @JsonProperty("Compiler")
    val compiler: CompilerSettings? = null,

    @JsonProperty("Required Plugins")
    val requiredPlugins: List<RequiredPlugin>? = null
)
