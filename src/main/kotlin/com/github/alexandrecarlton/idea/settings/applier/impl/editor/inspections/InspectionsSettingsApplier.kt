package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.InspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.JavaInspectionsSettings
import javax.inject.Inject

class InspectionsSettingsApplier @Inject
constructor(private val javaInspectionsSettingsApplier: SettingsApplier<JavaInspectionsSettings>)
    : SettingsApplier<InspectionsSettings> {

    override fun apply(settings: InspectionsSettings) {
        settings.java?.let(javaInspectionsSettingsApplier::apply)
    }

}
