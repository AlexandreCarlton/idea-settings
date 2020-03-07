package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.InspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.JavaInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.JavascriptInspectionsSettings
import javax.inject.Inject

class InspectionsSettingsApplier @Inject
constructor(
    private val javaInspectionsSettingsApplier: SettingsApplier<JavaInspectionsSettings>,
    private val javascriptInspectionsSettingsApplier: SettingsApplier<JavascriptInspectionsSettings>
) : SettingsApplier<InspectionsSettings> {

    override fun apply(settings: InspectionsSettings) {
        settings.java?.let(javaInspectionsSettingsApplier::apply)
        settings.javascript?.let(javascriptInspectionsSettingsApplier::apply)
    }

}
