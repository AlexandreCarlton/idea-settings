package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings.BooleanWithGlobalOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavascriptImportsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var javascriptImportsSettingsApplier: SettingsApplier<JavascriptImportsSettings>

    @Before
    public override fun setUp() {
        javascriptImportsSettingsApplier = JavascriptImportsSettingsApplier(platform.jsCodeStyleSettings)
    }

    @Test
    fun usePathsRelativeToTheProjectResourceOrSourcesRootsApplied() {
        assertThat(platform.jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.GLOBAL)
        javascriptImportsSettingsApplier.apply(JavascriptImportsSettings(usePathsRelativeToTheProjectResourceOrSourcesRoots = true))
        assertThat(platform.jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.TRUE)
    }
}
