package com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringBootConfigurationRunningApplicationUpdatePoliciesSettings(

    @JsonProperty("On 'Update' action")
    val onUpdateAction: SpringBootConfigurationUpdateActionPolicy? = null,

    @JsonProperty("On frame deactivation")
    val onFrameDeactivation: SpringBootConfigurationFrameDeactivationPolicy? = null
)
