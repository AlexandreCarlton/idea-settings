package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot

data class SpringBootConfigurationSettings(
    val mainClass: String,

    val environment: SpringBootConfigurationEnvironmentSettings? = null,

    val springBoot: SpringBootConfigurationSpringBootSettings? = null
)
