package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Classifies the type of configuration - useful for differentiating between configurations sharing the same name.
 */
enum class RunConfigurationType {

    @JsonProperty("Docker")
    DOCKER,

    @JsonProperty("Remote")
    REMOTE,

    @JsonProperty("Shell Script")
    SHELL_SCRIPT,

    @JsonProperty("Spring Boot")
    SPRING_BOOT
}
