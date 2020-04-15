package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.fasterxml.jackson.annotation.JsonProperty

enum class ProjectSdkType {

    @JsonProperty("Java")
    JAVA,

    @JsonProperty("Kotlin")
    KOTLIN
}
