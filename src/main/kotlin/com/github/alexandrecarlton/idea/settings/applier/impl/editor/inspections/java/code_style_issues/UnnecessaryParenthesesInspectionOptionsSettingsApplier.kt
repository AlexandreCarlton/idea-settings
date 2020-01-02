package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
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
