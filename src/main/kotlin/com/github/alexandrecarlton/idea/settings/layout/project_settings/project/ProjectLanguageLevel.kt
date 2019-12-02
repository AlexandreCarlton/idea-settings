package com.github.alexandrecarlton.idea.settings.layout.project_settings.project

import com.fasterxml.jackson.annotation.JsonProperty

enum class ProjectLanguageLevel {

    @JsonProperty("1.3")
    JAVA_1_3,

    @JsonProperty("1.4")
    JAVA_1_4,

    @JsonProperty("5")
    JAVA_5,

    @JsonProperty("6")
    JAVA_6,

    @JsonProperty("7")
    JAVA_7,

    @JsonProperty("8")
    JAVA_8,

    @JsonProperty("9")
    JAVA_9,

    @JsonProperty("10")
    JAVA_10,

    @JsonProperty("11")
    JAVA_11,

    @JsonProperty("12")
    JAVA_12,

    @JsonProperty("X")
    JAVA_X
}
