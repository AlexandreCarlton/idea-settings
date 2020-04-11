package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class JavaImportSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var applier: SettingsApplier<JavaImportsSettings>

    @Before
    public override fun setUp() {
        applier = JavaImportsSettingsApplier(platform.javaCodeStyleSettings)
    }

    @After
    public override fun tearDown() {
        // The normal tear-down tries to verify that Code Insight settings haven't changed,
        // so we restore this just before finishing up.
        platform.codeStyleSettings.copyFrom(CodeStyleSettings.getDefaults())
    }

    @Test
    fun classCountToUseWithImportSettingsAreApplied() {
        applier.apply(JavaImportsSettings(classCountToUseImportWithWildcard = 555))
        assertThat(platform.javaCodeStyleSettings.CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(555)
    }

    @Test
    fun namesCountToUseWithStaticImportSettingsAreApplied() {
        applier.apply(JavaImportsSettings(namesCountToUseStaticImportWithWildcard = 777))
        assertThat(platform.javaCodeStyleSettings.NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND).isEqualTo(777)
    }
}
