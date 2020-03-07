package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringBootConfigurationSettings(
    @JsonProperty("Main class")
    val mainClass: String,

    @JsonProperty("Environment")
    val environment: SpringBootConfigurationEnvironmentSettings? = null,

    @JsonProperty("Spring Boot")
    val springBoot: SpringBootConfigurationSpringBootSettings? = null
)
