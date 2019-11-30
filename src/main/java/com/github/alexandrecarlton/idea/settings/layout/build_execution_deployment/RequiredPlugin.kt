package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment

data class RequiredPlugin(
    val plugin: String,
    val minimumVersion: String? = null,
    val maximumVersion: String? = null
)
