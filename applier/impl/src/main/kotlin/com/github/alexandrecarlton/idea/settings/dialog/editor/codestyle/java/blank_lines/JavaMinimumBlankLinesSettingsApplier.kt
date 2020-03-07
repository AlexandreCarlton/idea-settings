package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class JavaMinimumBlankLinesSettingsApplier @Inject
constructor(@param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings,
            private val javaCodeStyleSettings: JavaCodeStyleSettings) : SettingsApplier<JavaMinimumBlankLinesSettings> {
    override fun apply(settings: JavaMinimumBlankLinesSettings) {
        settings.beforePackageStatement?.let { commonCodeStyleSettings.BLANK_LINES_BEFORE_PACKAGE = it }
        settings.afterPackageStatement?.let { commonCodeStyleSettings.BLANK_LINES_AFTER_PACKAGE = it }
        settings.beforeImports?.let { commonCodeStyleSettings.BLANK_LINES_BEFORE_IMPORTS = it }
        settings.afterImports?.let { commonCodeStyleSettings.BLANK_LINES_AFTER_IMPORTS = it }
        settings.aroundClass?.let { commonCodeStyleSettings.BLANK_LINES_AROUND_CLASS = it }
        settings.afterClassHeader?.let { commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER = it }
        settings.beforeClassEnd?.let { commonCodeStyleSettings.BLANK_LINES_BEFORE_CLASS_END = it }
        settings.afterAnonymousClassHeader?.let { commonCodeStyleSettings.BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER = it }
        settings.aroundFieldInInterface?.let { commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD_IN_INTERFACE = it }
        settings.aroundField?.let { commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD = it }
        settings.aroundMethodInInterface?.let { commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD_IN_INTERFACE = it }
        settings.aroundMethod?.let { commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD = it }
        settings.beforeMethodBody?.let { commonCodeStyleSettings.BLANK_LINES_BEFORE_METHOD_BODY = it }
        settings.aroundInitializer?.let { javaCodeStyleSettings.BLANK_LINES_AROUND_INITIALIZER = it }
    }
}
