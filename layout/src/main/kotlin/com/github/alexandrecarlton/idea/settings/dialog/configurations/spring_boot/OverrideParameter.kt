package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class OverrideParameter(

    @JsonProperty("Name")
    val name: String? = null,

    @JsonProperty("Value")
    val value: String? = null
)
