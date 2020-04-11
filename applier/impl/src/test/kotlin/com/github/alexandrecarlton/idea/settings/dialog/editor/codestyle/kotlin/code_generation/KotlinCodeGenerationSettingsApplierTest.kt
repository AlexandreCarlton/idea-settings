package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinCodeGenerationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinCodeGenerationSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinCodeGenerationSettingsApplier(platform.kotlinCommonCodeStyleSettings)
    }

    @Test
    fun addASpaceAtCommentStart() {
        assertThat(platform.kotlinCommonCodeStyleSettings.LINE_COMMENT_ADD_SPACE).isFalse()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                addASpaceAtCommentStart = true)))
        assertThat(platform.kotlinCommonCodeStyleSettings.LINE_COMMENT_ADD_SPACE).isTrue()
    }

    @Test
    fun blockCommentAtFirstColumn() {
        assertThat(platform.kotlinCommonCodeStyleSettings.BLOCK_COMMENT_AT_FIRST_COLUMN).isTrue()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                blockCommentAtFirstColumn = false)))
        assertThat(platform.kotlinCommonCodeStyleSettings.BLOCK_COMMENT_AT_FIRST_COLUMN).isFalse()
    }

    @Test
    fun lineCommentAtFirstColumn() {
        assertThat(platform.kotlinCommonCodeStyleSettings.LINE_COMMENT_AT_FIRST_COLUMN).isTrue()
        settingsApplier.apply(KotlinCodeGenerationSettings(
            commentCode = KotlinCommentCodeSettings(
                lineCommentAtFirstColumn = false)))
        assertThat(platform.kotlinCommonCodeStyleSettings.LINE_COMMENT_AT_FIRST_COLUMN).isFalse()
    }
}
