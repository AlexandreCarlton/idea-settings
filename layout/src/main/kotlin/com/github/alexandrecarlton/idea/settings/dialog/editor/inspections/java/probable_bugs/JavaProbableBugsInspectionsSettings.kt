package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettings

typealias ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings = BaseInspectionSettings<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>

data class JavaProbableBugsInspectionsSettings(

    @JsonProperty("Array comparison using '==', instead of 'Arrays.equals()'")
    val arrayComparisonUsingEqualsInsteadOfArraysEquals: ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings? = null
)
