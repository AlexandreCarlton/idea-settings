package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringBootConfigurationEnvironmentSettings(

    @JsonProperty("VM options")
    val vmOptions: String? = null,

    @JsonProperty("Include dependencies with provided scope")
    val includeDependenciesWithProvidedScope: Boolean? = null,

    @JsonProperty("Use classpath of module")
    val useClasspathOfModule: String? = null
)
