package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.imports

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject

class JavaImportsSettingsApplier @Inject
constructor(private val javaCodeStyleSettings: JavaCodeStyleSettings) : SettingsApplier<JavaImportsSettings> {

    override fun apply(settings: JavaImportsSettings) {
        settings.classCountToUseImportWithWildcard?.let { javaCodeStyleSettings.classCountToUseImportOnDemand = it }
        settings.namesCountToUseStaticImportWithWildcard?.let { javaCodeStyleSettings.namesCountToUseImportOnDemand = it }
    }
}
