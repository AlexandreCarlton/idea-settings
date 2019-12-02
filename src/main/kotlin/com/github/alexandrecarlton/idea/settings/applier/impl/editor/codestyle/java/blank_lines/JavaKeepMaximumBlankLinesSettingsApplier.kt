package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class JavaKeepMaximumBlankLinesSettingsApplier @Inject
constructor(@param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings) : SettingsApplier<JavaKeepMaximumBlankLinesSettings> {

    override fun apply(settings: JavaKeepMaximumBlankLinesSettings) {
        settings.inDeclarations?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS = it }
        settings.inCode?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE = it }
        settings.beforeRightBrace?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE = it }
        settings.betweenHeaderAndPackage?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_BETWEEN_PACKAGE_DECLARATION_AND_HEADER = it }
    }
}
