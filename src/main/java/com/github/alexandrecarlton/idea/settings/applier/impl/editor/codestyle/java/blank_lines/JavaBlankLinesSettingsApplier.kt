package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings
import javax.inject.Inject

class JavaBlankLinesSettingsApplier @Inject
constructor(private val javaKeepMaximumBlankLinesSettingsApplier: SettingsApplier<JavaKeepMaximumBlankLinesSettings>,
            private val javaMinimumBlankLinesSettingsApplier: SettingsApplier<JavaMinimumBlankLinesSettings>) : SettingsApplier<JavaBlankLinesSettings> {

    override fun apply(settings: JavaBlankLinesSettings) {
        settings.keepMaximumBlankLines?.let(javaKeepMaximumBlankLinesSettingsApplier::apply)
        settings.minimumBlankLines?.let(javaMinimumBlankLinesSettingsApplier::apply)
    }
}
