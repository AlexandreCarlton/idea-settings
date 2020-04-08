package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class KotlinCodeGenerationSettingsApplier @Inject constructor(
    @Named("Kotlin") private val commonCodeStyleSettings: CommonCodeStyleSettings
) : SettingsApplier<KotlinCodeGenerationSettings> {
    override fun apply(settings: KotlinCodeGenerationSettings) {
        settings.commentCode?.addASpaceAtCommentStart?.let { commonCodeStyleSettings.LINE_COMMENT_ADD_SPACE = it }
        settings.commentCode?.blockCommentAtFirstColumn?.let { commonCodeStyleSettings.BLOCK_COMMENT_AT_FIRST_COLUMN = it }
        settings.commentCode?.lineCommentAtFirstColumn?.let { commonCodeStyleSettings.LINE_COMMENT_AT_FIRST_COLUMN = it }
    }
}
