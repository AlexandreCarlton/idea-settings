package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings
import javax.inject.Inject

class JavascriptCodeStyleSettingsApplier @Inject
constructor(private val javascriptImportsSettingsApplier: SettingsApplier<JavascriptImportsSettings>) : SettingsApplier<JavascriptCodeStyleSettings> {

    override fun apply(settings: JavascriptCodeStyleSettings) {
        settings.imports().ifPresent { javascriptImportsSettingsApplier.apply(it) }
    }
}
