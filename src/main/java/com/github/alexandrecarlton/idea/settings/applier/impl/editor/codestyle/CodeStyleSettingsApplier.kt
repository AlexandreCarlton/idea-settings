package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings
import javax.inject.Inject

class CodeStyleSettingsApplier @Inject
constructor(private val javaCodeStyleSettingsApplier: SettingsApplier<JavaCodeStyleSettings>,
            private val javascriptCodeStyleSettingsApplier: SettingsApplier<JavascriptCodeStyleSettings>) : SettingsApplier<CodeStyleSettings> {

    override fun apply(settings: CodeStyleSettings) {
        settings.java().ifPresent { javaCodeStyleSettingsApplier.apply(it) }
        settings.javascript().ifPresent { javascriptCodeStyleSettingsApplier.apply(it) }
    }
}
