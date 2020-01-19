package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.EslintInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettings
import javax.inject.Inject

class JavascriptCodeQualityToolsInspectionsSettingsApplier @Inject
constructor(
   private val eslintInspectionSettingsApplier: SettingsApplier<EslintInspectionSettings>
): SettingsApplier<JavascriptCodeQualityToolsInspectionsSettings> {
    override fun apply(settings: JavascriptCodeQualityToolsInspectionsSettings) {
        settings.eslint?.let(eslintInspectionSettingsApplier::apply)
    }
}
