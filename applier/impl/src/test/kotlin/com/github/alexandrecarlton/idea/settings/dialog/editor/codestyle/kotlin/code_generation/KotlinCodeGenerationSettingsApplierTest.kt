package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.application.options.CodeStyle
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.junit.Before
import org.junit.Test

class KotlinCodeGenerationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinCodeGenerationSettings>
    private lateinit var commonCodeStyleSettings: CommonCodeStyleSettings

    @Before
    public override fun setUp() {
        commonCodeStyleSettings = CodeStyle.getSettings(project).getCommonSettings(KotlinLanguage.INSTANCE)
        settingsApplier = KotlinCodeGenerationSettingsApplier(commonCodeStyleSettings)
    }

    @Test
    fun addASpaceAtCommentStart() {
        assertThat(commonCodeStyleSettings.LINE_COMMENT_ADD_SPACE).isFalse()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                addASpaceAtCommentStart = true)))
        assertThat(commonCodeStyleSettings.LINE_COMMENT_ADD_SPACE).isTrue()
    }

    @Test
    fun blockCommentAtFirstColumn() {
        assertThat(commonCodeStyleSettings.BLOCK_COMMENT_AT_FIRST_COLUMN).isTrue()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                blockCommentAtFirstColumn = false)))
        assertThat(commonCodeStyleSettings.BLOCK_COMMENT_AT_FIRST_COLUMN).isFalse()
    }

    @Test
    fun lineCommentAtFirstColumn() {
        assertThat(commonCodeStyleSettings.LINE_COMMENT_AT_FIRST_COLUMN).isTrue()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                lineCommentAtFirstColumn = false)))
        assertThat(commonCodeStyleSettings.LINE_COMMENT_AT_FIRST_COLUMN).isFalse()
    }
}
