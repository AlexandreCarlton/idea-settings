package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.codeInspection.InspectionProfileEntry
import javax.inject.Inject
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

class MissingDeprecatedAnnotationInspectionOptionsSettingsApplier @Inject
constructor(
    // MissingDeprecatedAnnotationInspection is not public, so we resort to reflection shenanigans.
    private val inspectionProfileEntry: InspectionProfileEntry
) : SettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings> {
    override fun apply(settings: MissingDeprecatedAnnotationInspectionOptionsSettings) {
        settings.warnOnMissingDeprecatedJavadocTagExplanation?.let {
            val warnOnMissingJavadoc = inspectionProfileEntry::class.memberProperties.find { it.name == "warnOnMissingJavadoc" }
            if (warnOnMissingJavadoc is KMutableProperty<*>) {
                warnOnMissingJavadoc.isAccessible = true
                warnOnMissingJavadoc.setter.call(inspectionProfileEntry, it)
            }
        }
    }
}
