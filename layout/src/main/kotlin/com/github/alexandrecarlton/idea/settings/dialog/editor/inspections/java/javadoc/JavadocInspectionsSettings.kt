package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettings

typealias MissingDeprecatedAnnotationInspectionSettings = BaseInspectionSettings<MissingDeprecatedAnnotationInspectionOptionsSettings>

data class JavadocInspectionsSettings(

    @JsonProperty("Missing @Deprecated annotation")
    val missingDeprecatedAnnotation: MissingDeprecatedAnnotationInspectionSettings? = null

)
