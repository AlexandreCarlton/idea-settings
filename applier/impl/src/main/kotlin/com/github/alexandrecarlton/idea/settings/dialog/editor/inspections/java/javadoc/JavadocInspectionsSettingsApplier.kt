package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.javadoc.JavadocInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.javadoc.MissingDeprecatedAnnotationInspectionSettings
import javax.inject.Inject

class JavadocInspectionsSettingsApplier @Inject
constructor (
    private val missingDeprecatedAnnotationInspectionSettingsApplier: SettingsApplier<MissingDeprecatedAnnotationInspectionSettings>
) : SettingsApplier<JavadocInspectionsSettings> {
    override fun apply(settings: JavadocInspectionsSettings) {
        settings.missingDeprecatedAnnotation?.let(missingDeprecatedAnnotationInspectionSettingsApplier::apply)
    }
}
