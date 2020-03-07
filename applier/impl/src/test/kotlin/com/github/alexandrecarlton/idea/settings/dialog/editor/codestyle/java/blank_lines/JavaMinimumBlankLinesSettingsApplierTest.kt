package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavaMinimumBlankLinesSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings
    private lateinit var javaCodeStyleSettings: JavaCodeStyleSettings
    private lateinit var settingsApplier: SettingsApplier<JavaMinimumBlankLinesSettings>

    @Before
    public override fun setUp() {
        val codeStyleSettings = CodeStyle.getSettings(project)
        commonCodeStyleSettings = codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)
        javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings::class.java)
        settingsApplier = JavaMinimumBlankLinesSettingsApplier(commonCodeStyleSettings, javaCodeStyleSettings)
    }

    @Test
    fun minimumBlankLinesBeforePackageStatement() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(beforePackageStatement = 10))
        assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_PACKAGE).isEqualTo(10)
    }

    @Test
    fun minimumBlankLinesAfterPackageStatement() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(afterPackageStatement = 11))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_PACKAGE).isEqualTo(11)
    }

    @Test
    fun minimumBlankLinesBeforeImports() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(beforeImports = 12))
        assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_IMPORTS).isEqualTo(12)
    }

    @Test
    fun minimumBlankLinesAfterImports() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(afterImports = 13))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_IMPORTS).isEqualTo(13)
    }

    @Test
    fun minimumBlankLinesAroundClass() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundClass = 14))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_CLASS).isEqualTo(14)
    }

    @Test
    fun minimumBlankLinesAfterClassHeader() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(afterClassHeader = 15))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER).isEqualTo(15)
    }

    @Test
    fun minimumBlankLinesBeforeClassEnd() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(beforeClassEnd = 16))
        assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_CLASS_END).isEqualTo(16)
    }

    @Test
    fun minimumBlankLinesAfterAnonymousClassHeader() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(afterAnonymousClassHeader = 17))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AFTER_ANONYMOUS_CLASS_HEADER).isEqualTo(17)
    }

    @Test
    fun minimumBlankLinesAroundFieldInInterface() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundFieldInInterface = 18))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD_IN_INTERFACE).isEqualTo(18)
    }

    @Test
    fun minimumBlankLinesAroundField() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundField = 19))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_FIELD).isEqualTo(19)
    }

    @Test
    fun minimumBlankLinesAroundMethodInInterface() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundMethodInInterface = 20))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD_IN_INTERFACE).isEqualTo(20)
    }

    @Test
    fun minimumBlankLinesAroundMethod() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundMethod = 21))
        assertThat(commonCodeStyleSettings.BLANK_LINES_AROUND_METHOD).isEqualTo(21)
    }

    @Test
    fun minimumBlankLinesBeforeMethodBody() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(beforeMethodBody = 22))
        assertThat(commonCodeStyleSettings.BLANK_LINES_BEFORE_METHOD_BODY).isEqualTo(22)
    }

    @Test
    fun minimumBlankLinesAroundInitializer() {
        settingsApplier.apply(JavaMinimumBlankLinesSettings(aroundInitializer = 23))
        assertThat(javaCodeStyleSettings.BLANK_LINES_AROUND_INITIALIZER).isEqualTo(23)
    }
}
