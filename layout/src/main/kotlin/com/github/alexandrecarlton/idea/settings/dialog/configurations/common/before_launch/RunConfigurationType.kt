package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Classifies the type of configuration - useful for differentiating between configurations sharing the same name.
 */
enum class RunConfigurationType {

    @JsonProperty("Application")
    APPLICATION,

    @JsonProperty("Docker")
    DOCKER,

    @JsonProperty("Remote")
    REMOTE,

    @JsonProperty("Spring Boot")
    SPRING_BOOT
}
