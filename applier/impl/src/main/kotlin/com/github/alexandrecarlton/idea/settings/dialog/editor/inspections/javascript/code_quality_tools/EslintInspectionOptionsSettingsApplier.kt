package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.lang.javascript.linter.eslint.EslintInspection
import javax.inject.Inject

class EslintInspectionOptionsSettingsApplier @Inject
constructor(
    private val eslintInspection: EslintInspection
): SettingsApplier<EslintInspectionOptionsSettings> {
    override fun apply(settings: EslintInspectionOptionsSettings) {
        settings.useRuleSeverityFromTheConfigurationFile?.let { eslintInspection.useSeverityFromConfigFile = it }
    }
}
