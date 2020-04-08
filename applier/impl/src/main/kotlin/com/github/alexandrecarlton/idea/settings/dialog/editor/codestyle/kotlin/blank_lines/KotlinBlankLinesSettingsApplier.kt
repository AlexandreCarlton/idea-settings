package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import org.jetbrains.kotlin.idea.core.formatter.KotlinCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class KotlinBlankLinesSettingsApplier @Inject
constructor(
    @Named("Kotlin") private val commonCodeStyleSettings: CommonCodeStyleSettings,
    private val kotlinCodeStyleSettings: KotlinCodeStyleSettings
) : SettingsApplier<KotlinBlankLinesSettings> {
    override fun apply(settings: KotlinBlankLinesSettings) {
        settings.keepMaximumBlankLines?.beforeRightBrace?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_BEFORE_RBRACE = it }
        settings.keepMaximumBlankLines?.inCode?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_IN_CODE = it }
        settings.keepMaximumBlankLines?.inDeclarations?.let { commonCodeStyleSettings.KEEP_BLANK_LINES_IN_DECLARATIONS = it }

        settings.minimumBlankLines?.afterClassHeader?.let { commonCodeStyleSettings.BLANK_LINES_AFTER_CLASS_HEADER = it }
        settings.minimumBlankLines?.aroundWhenBranchesWithBraces?.let { kotlinCodeStyleSettings.BLANK_LINES_AROUND_BLOCK_WHEN_BRANCHES = it }
    }
}
