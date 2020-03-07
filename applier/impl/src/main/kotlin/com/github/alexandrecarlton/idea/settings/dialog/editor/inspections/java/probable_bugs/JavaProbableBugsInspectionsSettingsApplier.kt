package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.probable_bugs.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsSettings
import javax.inject.Inject

class JavaProbableBugsInspectionsSettingsApplier @Inject
constructor(
    private val arrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier: SettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettings>
) : SettingsApplier<JavaProbableBugsInspectionsSettings> {
    override fun apply(settings: JavaProbableBugsInspectionsSettings) {
        settings.arrayComparisonUsingEqualsInsteadOfArraysEquals?.let(arrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier::apply)
    }
}
