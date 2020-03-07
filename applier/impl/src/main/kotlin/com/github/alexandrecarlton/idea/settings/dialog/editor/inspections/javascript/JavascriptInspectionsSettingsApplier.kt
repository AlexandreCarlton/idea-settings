package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettings
import javax.inject.Inject

class JavascriptInspectionsSettingsApplier @Inject
constructor(
    private val javascriptCodeQualityToolsInspectionsSettingsApplier: SettingsApplier<JavascriptCodeQualityToolsInspectionsSettings>
): SettingsApplier<JavascriptInspectionsSettings> {
    override fun apply(settings: JavascriptInspectionsSettings) {
        settings.codeQualityTools?.let(javascriptCodeQualityToolsInspectionsSettingsApplier::apply)
    }
}

