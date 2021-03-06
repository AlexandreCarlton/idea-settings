package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement.JavaArrangementSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines.JavaBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports.JavaImportsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc.JavadocSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings
import javax.inject.Inject

class JavaCodeStyleSettingsApplier @Inject
constructor(private val javaArrangementSettingsApplier: SettingsApplier<JavaArrangementSettings>,
            private val javaBlankLinesSettingsApplier: SettingsApplier<JavaBlankLinesSettings>,
            private val javaImportsSettingsApplier: SettingsApplier<JavaImportsSettings>,
            private val javadocSettingsApplier: SettingsApplier<JavadocSettings>,
            private val javaWrappingAndBracesSettingsApplier: SettingsApplier<JavaWrappingAndBracesSettings>) : SettingsApplier<JavaCodeStyleSettings> {

    override fun apply(settings: JavaCodeStyleSettings) {
        settings.arrangement?.let(javaArrangementSettingsApplier::apply)
        settings.blankLines?.let(javaBlankLinesSettingsApplier::apply)
        settings.imports?.let(javaImportsSettingsApplier::apply)
        settings.javadoc?.let(javadocSettingsApplier::apply)
        settings.wrappingAndBraces?.let(javaWrappingAndBracesSettingsApplier::apply)
    }
}
