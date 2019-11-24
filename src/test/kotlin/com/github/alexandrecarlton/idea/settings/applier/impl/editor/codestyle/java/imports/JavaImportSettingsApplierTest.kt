package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.imports

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.ImmutableJavaImportsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings
import com.intellij.application.options.CodeStyle
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class JavaImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var javaCodeStyleSettings: JavaCodeStyleSettings
    private lateinit var applier: SettingsApplier<JavaImportsSettings>

    @Before
    public override fun setUp() {
        javaCodeStyleSettings = CodeStyle.getSettings(project).getCustomSettings(JavaCodeStyleSettings::class.java)
        applier = JavaImportsSettingsApplier(javaCodeStyleSettings)
    }

    @After
    public override fun tearDown() {
        // The normal tear-down tries to verify that Code Insight settings haven't changed,
        // so we restore this just before finishing up.
        CodeStyle.getSettings(project).copyFrom(CodeStyleSettings.getDefaults())
    }

    @Test
    fun classCountToUseWithImportSettingsAreApplied() {
        applier.apply(ImmutableJavaImportsSettings.builder()
            .classCountToUseImportWithWildcard(555)
            .build())
        assertThat(javaCodeStyleSettings.CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(555)
    }

    @Test
    fun namesCountToUseWithStaticImportSettingsAreApplied() {
        applier.apply(ImmutableJavaImportsSettings.builder()
            .namesCountToUseStaticImportWithWildcard(777)
            .build())
        assertThat(javaCodeStyleSettings.NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(777)
    }
}
