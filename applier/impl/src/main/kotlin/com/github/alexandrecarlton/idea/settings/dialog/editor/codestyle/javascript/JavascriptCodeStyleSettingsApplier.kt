package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class JavascriptCodeStyleSettingsApplier @Inject
constructor(private val javascriptImportsSettingsApplier: SettingsApplier<JavascriptImportsSettings>) : SettingsApplier<JavascriptCodeStyleSettings> {

    override fun apply(settings: JavascriptCodeStyleSettings) {
        settings.imports?.let(javascriptImportsSettingsApplier::apply)
    }
}
