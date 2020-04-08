package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class KotlinWrappingAndBracesSettingsApplier @Inject
constructor(
    @Named("Kotlin") private val commonCodeStyleSettings: CommonCodeStyleSettings
) : SettingsApplier<KotlinWrappingAndBracesSettings> {
    override fun apply(settings: KotlinWrappingAndBracesSettings) {
        settings.functionDeclarationParameters?.alignWhenMultiline?.let { commonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS = it }
    }
}
