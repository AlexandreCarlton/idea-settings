package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class KotlinTabsAndIndentsSettingsApplier @Inject
constructor(
    @Named("Kotlin") private val commonCodeStyleSettings: CommonCodeStyleSettings
) : SettingsApplier<KotlinTabsAndIndentsSettings> {
    override fun apply(settings: KotlinTabsAndIndentsSettings) {
        settings.continuationIndent?.let { commonCodeStyleSettings.indentOptions?.CONTINUATION_INDENT_SIZE = it }
    }
}
