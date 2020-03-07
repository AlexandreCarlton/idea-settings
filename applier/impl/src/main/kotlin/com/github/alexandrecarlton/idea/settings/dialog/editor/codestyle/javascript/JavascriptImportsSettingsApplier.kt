package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings.BooleanWithGlobalOption
import javax.inject.Inject

class JavascriptImportsSettingsApplier @Inject
constructor(private val jsCodeStyleSettings: JSCodeStyleSettings) : SettingsApplier<JavascriptImportsSettings> {

    override fun apply(settings: JavascriptImportsSettings) {
        settings.usePathsRelativeToTheProjectResourceOrSourcesRoots?.let { jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH = toBooleanWithGlobalOption(it) }
    }

    private fun toBooleanWithGlobalOption(value: Boolean) =
        if (value) BooleanWithGlobalOption.TRUE else BooleanWithGlobalOption.FALSE
}
