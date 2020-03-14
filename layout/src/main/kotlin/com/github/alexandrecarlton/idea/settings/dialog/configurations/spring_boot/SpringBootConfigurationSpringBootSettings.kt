package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringBootConfigurationSpringBootSettings(

    @JsonProperty("Enable debug output")
    val enableDebugOutput: Boolean? = null,

    @JsonProperty("Hide banner")
    val hideBanner: Boolean? = null,

    @JsonProperty("Enable launch optimization")
    val enableLaunchOptimization: Boolean? = null,

    @JsonProperty("Enable JMX agent")
    val enableJmxAgent: Boolean? = null,

    @JsonProperty("Override parameters")
    val overrideParameters: List<OverrideParameter>? = null
)
