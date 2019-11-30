package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot

data class SpringBootConfigurationEnvironmentSettings(
    val vmOptions: String? = null,

    val includeDependenciesWithProvidedScope: Boolean? = null,

    val useClassPathOfModule: String? = null
)
