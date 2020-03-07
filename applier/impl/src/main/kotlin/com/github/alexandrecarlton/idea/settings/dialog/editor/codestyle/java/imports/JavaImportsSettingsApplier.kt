package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject

class JavaImportsSettingsApplier @Inject
constructor(private val javaCodeStyleSettings: JavaCodeStyleSettings) : SettingsApplier<JavaImportsSettings> {

    override fun apply(settings: JavaImportsSettings) {
        settings.classCountToUseImportWithWildcard?.let { javaCodeStyleSettings.classCountToUseImportOnDemand = it }
        settings.namesCountToUseStaticImportWithWildcard?.let { javaCodeStyleSettings.namesCountToUseImportOnDemand = it }
    }
}
