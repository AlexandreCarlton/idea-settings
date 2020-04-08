package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.junit.Before
import org.junit.Test

class KotlinTabsAndIndentsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinTabsAndIndentsSettings>
    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings

    @Before
    public override fun setUp() {
        commonCodeStyleSettings = CodeStyle.getSettings(project).getCommonSettings(KotlinLanguage.INSTANCE)
        settingsApplier = KotlinTabsAndIndentsSettingsApplier(commonCodeStyleSettings)
    }

    @Test
    fun continuationIndent() {
        settingsApplier.apply(KotlinTabsAndIndentsSettings(
            continuationIndent = 12))
        assertThat(commonCodeStyleSettings.indentOptions?.CONTINUATION_INDENT_SIZE).isEqualTo(12)
    }
}
