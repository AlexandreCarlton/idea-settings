package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

enum class SpringBootConfigurationFrameDeactivationPolicy {

    @JsonProperty("Do nothing")
    DO_NOTHING,

    @JsonProperty("Update resources")
    UPDATE_RESOURCES,

    @JsonProperty("Update classes and resources")
    UPDATE_CLASSES_AND_RESOURCES
}
