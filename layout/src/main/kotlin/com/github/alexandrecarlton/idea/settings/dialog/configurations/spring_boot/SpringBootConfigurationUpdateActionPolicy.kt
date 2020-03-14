package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

enum class SpringBootConfigurationUpdateActionPolicy {

    @JsonProperty("Do nothing")
    DO_NOTHING,

    @JsonProperty("Update resources")
    UPDATE_RESOURCES,

    @JsonProperty("Update classes and resources")
    UPDATE_CLASSES_AND_RESOURCES,

    @JsonProperty("Update trigger file")
    UPDATE_TRIGGER_FILE,

    @JsonProperty("Hot swap classes and update trigger file if failed")
    HOT_SWAP_CLASSES_AND_UPDATE_TRIGGER_FILE_IF_FAILED
}
