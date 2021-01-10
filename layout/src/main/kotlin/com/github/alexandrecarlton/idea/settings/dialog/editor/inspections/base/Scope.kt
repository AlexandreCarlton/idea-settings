package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base

import com.fasterxml.jackson.annotation.JsonProperty

enum class Scope {
    @JsonProperty("In All Scopes")
    IN_ALL_SCOPES,

    @JsonProperty("Everywhere Else")
    EVERYWHERE_ELSE,

    @JsonProperty("Project Files")
    PROJECT_FILES,

    @JsonProperty("Scratches and Consoles")
    SCRATCHES_AND_CONSOLES,

    @JsonProperty("Production")
    PRODUCTION,

    @JsonProperty("Tests")
    TESTS,

    @JsonProperty("Open Files")
    OPEN_FILES,

    // Requires a ChangeListManager, let's see if we can work around this.
//    @JsonProperty("All Changed Files")
//    ALL_CHANGED_FILES,

    // Requires a ChangeListManager to be injected.
    // @JsonProperty("Default Changelist")
    // DEFAULT_CHANGELIST
}
