package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript.JavascriptCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.KotlinCodeStyleSettings
import javax.inject.Inject

class CodeStyleSettingsApplier @Inject
constructor(
    private val javaCodeStyleSettingsApplier: SettingsApplier<JavaCodeStyleSettings>,
    private val javascriptCodeStyleSettingsApplier: SettingsApplier<JavascriptCodeStyleSettings>,
    private val kotlinCodeStyleSettingsApplier: SettingsApplier<KotlinCodeStyleSettings>
) : SettingsApplier<CodeStyleSettings> {
    override fun apply(settings: CodeStyleSettings) {
        settings.java?.let(javaCodeStyleSettingsApplier::apply)
        settings.javascript?.let(javascriptCodeStyleSettingsApplier::apply)
        settings.kotlin?.let(kotlinCodeStyleSettingsApplier::apply)
    }
}
