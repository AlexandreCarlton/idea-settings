package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.siyeh.ig.javadoc.MissingDeprecatedAnnotationInspection
import javax.inject.Inject

class MissingDeprecatedAnnotationInspectionOptionsSettingsApplier @Inject
constructor(
    private val missingDeprecatedAnnotationInspection: MissingDeprecatedAnnotationInspection
) : SettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings> {
    override fun apply(settings: MissingDeprecatedAnnotationInspectionOptionsSettings) {
        settings.warnOnMissingDeprecatedJavadocTagExplanation?.let {
            missingDeprecatedAnnotationInspection.warnOnMissingJavadoc = it
        }
    }
}
