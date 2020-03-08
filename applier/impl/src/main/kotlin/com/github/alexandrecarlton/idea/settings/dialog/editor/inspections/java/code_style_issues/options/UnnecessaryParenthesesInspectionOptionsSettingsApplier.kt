package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.siyeh.ig.style.UnnecessaryParenthesesInspection
import javax.inject.Inject


class UnnecessaryParenthesesInspectionOptionsSettingsApplier @Inject
constructor(private val unnecessaryParenthesesInspection: UnnecessaryParenthesesInspection)
: SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings> {

    override fun apply(settings: UnnecessaryParenthesesInspectionOptionsSettings) {
        settings.ignoreClarifyingPatterns
            ?.let { unnecessaryParenthesesInspection.ignoreClarifyingParentheses = it }
        settings.ignoreParenthesesAroundTheConditionOfConditionalExpressions
            ?.let { unnecessaryParenthesesInspection.ignoreParenthesesOnConditionals = it }
        settings.ignoreParenthesesAroundSingleNoFormalTypeLambdaParameter
            ?.let { unnecessaryParenthesesInspection.ignoreParenthesesOnLambdaParameter = it }
    }
}
