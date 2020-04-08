package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.KotlinDefaultCodeStyle.KOTLIN_OBSOLETE_INTELLIJ_IDEA_CODESTYLE
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.KotlinDefaultCodeStyle.KOTLIN_STYLE_GUIDE
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.blank_lines.KotlinBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation.KotlinCodeGenerationSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports.KotlinImportsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.tabs_and_indents.KotlinTabsAndIndentsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.wrapping_and_braces.KotlinWrappingAndBracesSettings
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.jetbrains.kotlin.idea.formatter.KotlinObsoleteCodeStyle
import org.jetbrains.kotlin.idea.formatter.KotlinPredefinedCodeStyle
import org.jetbrains.kotlin.idea.formatter.KotlinStyleGuideCodeStyle
import javax.inject.Inject

class KotlinCodeStyleSettingsApplier @Inject
constructor(
    private val codeStyleSettings: CodeStyleSettings,

    private val blankLinesSettingsApplier: SettingsApplier<KotlinBlankLinesSettings>,
    private val codeGenerationSettingsApplier: SettingsApplier<KotlinCodeGenerationSettings>,
    private val importsSettingsApplier: SettingsApplier<KotlinImportsSettings>,
    private val tabsAndIndentsSettingsApplier: SettingsApplier<KotlinTabsAndIndentsSettings>,
    private val wrappingAndBracesSettingsApplier: SettingsApplier<KotlinWrappingAndBracesSettings>
) : SettingsApplier<KotlinCodeStyleSettings> {
    override fun apply(settings: KotlinCodeStyleSettings) {

        // Apply the defaults first so that subsequent settings can override them.
        settings.setFrom
            ?.let { toCodeStyle(it) }
            ?.apply(codeStyleSettings)

        settings.blankLines?.let(blankLinesSettingsApplier::apply)
        settings.codeGeneration?.let(codeGenerationSettingsApplier::apply)
        settings.imports?.let(importsSettingsApplier::apply)
        settings.tabsAndIndents?.let(tabsAndIndentsSettingsApplier::apply)
        settings.wrappingAndBraces?.let(wrappingAndBracesSettingsApplier::apply)
    }

    private fun toCodeStyle(guide: KotlinDefaultCodeStyle): KotlinPredefinedCodeStyle = when(guide) {
        KOTLIN_STYLE_GUIDE -> KotlinStyleGuideCodeStyle()
        KOTLIN_OBSOLETE_INTELLIJ_IDEA_CODESTYLE -> KotlinObsoleteCodeStyle()
    }

}
