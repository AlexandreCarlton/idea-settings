package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class MissingDeprecatedAnnotationInspectionOptionsSettings(
    @JsonProperty("Warn on missing @deprecated Javadoc tag explanation")
    val warnOnMissingDeprecatedJavadocTagExplanation : Boolean? = null
)
