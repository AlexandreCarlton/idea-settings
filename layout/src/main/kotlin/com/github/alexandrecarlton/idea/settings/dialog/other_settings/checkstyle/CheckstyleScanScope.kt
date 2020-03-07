package com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle

import com.fasterxml.jackson.annotation.JsonProperty

enum class CheckstyleScanScope {

    @JsonProperty("Only Java sources (but not tests)")
    ONLY_JAVA_SOURCES_BUT_NOT_TESTS,

    @JsonProperty("Only Java sources (including tests)")
    ONLY_JAVA_SOURCES_INCLUDING_TESTS,

    @JsonProperty("All sources (but not tests)")
    ALL_SOURCES_BUT_NOT_TESTS,

    @JsonProperty("All sources (including tests)")
    ALL_SOURCES_INCLUDING_TESTS,

    @JsonProperty("All files in project")
    ALL_FILES_IN_PROJECT
}
