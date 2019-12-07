package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringBootConfigurationSpringBootSettings(

    @JsonProperty("Override parameters")
    val overrideParameters: List<OverrideParameter>? = null
)
