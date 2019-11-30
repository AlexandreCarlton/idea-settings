package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class JavaMinimumBlankLinesSettingsApplier @Inject
constructor(@param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings,
            private val javaCodeStyleSettings: JavaCodeStyleSettings) : SettingsApplier<JavaMinimumBlankLinesSettings> {
    override fun apply(settings: JavaMinimumBlankLinesSettings) {
        settings.beforePackageStatement()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_BEFORE_PACKAGE = it }
        settings.afterPackageStatement()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AFTER_PACKAGE = it }
        settings.beforeImports()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_BEFORE_IMPORTS = it }
        settings.afterImports()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AFTER_IMPORTS = it }
        settings.aroundClass()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AROUND_CLASS = it }
        settings.afterClassHeader()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER = it }
        settings.beforeClassEnd()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_BEFORE_CLASS_END = it }
        settings.afterAnonymousClassHeader()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER = it }
        settings.aroundFieldInInterface()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD_IN_INTERFACE = it }
        settings.aroundField()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD = it }
        settings.aroundMethodInInterface()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD_IN_INTERFACE = it }
        settings.aroundMethod()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD = it }
        settings.beforeMethodBody()
            .ifPresent { commonCodeStyleSettings.BLANK_LINES_BEFORE_METHOD_BODY = it }
        settings.aroundInitializer()
            .ifPresent { javaCodeStyleSettings.BLANK_LINES_AROUND_INITIALIZER = it }
    }
}
