package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettings
import javax.inject.Inject

class JavascriptCodeQualityToolsSettingsApplier @Inject
constructor(
    private val eslintSettingsApplier: SettingsApplier<EslintSettings>
) : SettingsApplier<JavascriptCodeQualityToolsSettings> {
    override fun apply(settings: JavascriptCodeQualityToolsSettings) {
        settings.eslint?.let(eslintSettingsApplier::apply)
    }
}
