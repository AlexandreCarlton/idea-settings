package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.JavaInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.JavascriptInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.KotlinInspectionsSettings
import javax.inject.Inject

class InspectionsSettingsApplier @Inject
constructor(
    private val javaInspectionsSettingsApplier: SettingsApplier<JavaInspectionsSettings>,
    private val javascriptInspectionsSettingsApplier: SettingsApplier<JavascriptInspectionsSettings>,
    private val kotlinInspectionsSettingsApplier: SettingsApplier<KotlinInspectionsSettings>
) : SettingsApplier<InspectionsSettings> {

    override fun apply(settings: InspectionsSettings) {
        settings.java?.let(javaInspectionsSettingsApplier::apply)
        settings.javascript?.let(javascriptInspectionsSettingsApplier::apply)
        settings.kotlin?.let(kotlinInspectionsSettingsApplier::apply)
    }

}
