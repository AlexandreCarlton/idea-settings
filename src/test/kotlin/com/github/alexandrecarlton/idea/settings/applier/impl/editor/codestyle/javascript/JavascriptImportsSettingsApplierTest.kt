package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.ImmutableJavascriptImportsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings
import com.intellij.application.options.CodeStyle
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings.BooleanWithGlobalOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavascriptImportsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var jsCodeStyleSettings: JSCodeStyleSettings
    private lateinit var javascriptImportsSettingsApplier: SettingsApplier<JavascriptImportsSettings>

    @Before
    public override fun setUp() {
        jsCodeStyleSettings = CodeStyle.getSettings(project).getCustomSettings(JSCodeStyleSettings::class.java)
        javascriptImportsSettingsApplier = JavascriptImportsSettingsApplier(jsCodeStyleSettings)
    }

    @Test
    fun usePathsRelativeToTheProjectResourceOrSourcesRootsApplied() {
        assertThat(jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.GLOBAL)
        javascriptImportsSettingsApplier.apply(ImmutableJavascriptImportsSettings.builder()
            .usePathsRelativeToTheProjectResourceOrSourcesRoots(true)
            .build())
        assertThat(jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.TRUE)
    }
}
