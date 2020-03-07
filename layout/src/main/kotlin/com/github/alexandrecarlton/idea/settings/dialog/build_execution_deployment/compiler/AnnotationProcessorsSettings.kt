package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.fasterxml.jackson.annotation.JsonProperty

data class AnnotationProcessorsSettings(
    @JsonProperty("Enable annotation processing")
    val enableAnnotationProcessing: Boolean? = null
)
