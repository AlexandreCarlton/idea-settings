package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class JavaBlankLinesSettingsApplier @Inject
constructor(private val javaKeepMaximumBlankLinesSettingsApplier: SettingsApplier<JavaKeepMaximumBlankLinesSettings>,
            private val javaMinimumBlankLinesSettingsApplier: SettingsApplier<JavaMinimumBlankLinesSettings>) : SettingsApplier<JavaBlankLinesSettings> {

    override fun apply(settings: JavaBlankLinesSettings) {
        settings.keepMaximumBlankLines?.let(javaKeepMaximumBlankLinesSettingsApplier::apply)
        settings.minimumBlankLines?.let(javaMinimumBlankLinesSettingsApplier::apply)
    }
}
